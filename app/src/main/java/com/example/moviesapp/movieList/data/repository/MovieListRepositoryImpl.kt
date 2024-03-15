package com.example.moviesapp.movieList.data.repository

import com.example.moviesapp.movieList.data.local.movie.MovieDatabase
import com.example.moviesapp.movieList.data.mappers.toMovie
import com.example.moviesapp.movieList.data.mappers.toMovieEntity
import com.example.moviesapp.movieList.data.remote.MovieApi
import com.example.moviesapp.movieList.domain.model.Movie
import com.example.moviesapp.movieList.domain.repository.MovieListRepository
import com.example.moviesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)

            val shouldLoadFromLocalMovie = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadFromLocalMovie){
                emit(Resource.Success(data = localMovieList.map {
                    it.toMovie(category)
                }))
                emit(Resource.Loading(isLoading = false))
                return@flow

            }

            val movieListFromApi = try {
                movieApi.getMoviesList(category,page)

            }catch (e:IOException){
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading movies"))
                return@flow

            }catch (e:HttpException){
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading movies"))
                return@flow

            }catch (e:SocketTimeoutException){
                e.printStackTrace()
                emit(Resource.Error(message = "Error Loading movies"))
                return@flow
            }


            val movieEntities = movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }

            movieDatabase.movieDao.upsertMovieList(movieEntities)

            emit(Resource.Success(
                movieEntities.map { it.toMovie(category) }
            ))
            emit(Resource.Loading(false))



        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            val movieEntity = movieDatabase.movieDao.getMovieById(id)

            if(movieEntity != null){
                emit(Resource.Success(data = movieEntity.toMovie(movieEntity.category)))

                emit(Resource.Loading(isLoading = false))

                return@flow
            }
            emit(Resource.Error(message = "Movie not found"))

            emit(Resource.Loading(isLoading = false))

        }
    }
}