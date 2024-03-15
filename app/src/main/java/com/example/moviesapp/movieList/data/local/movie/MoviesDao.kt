package com.example.moviesapp.movieList.data.local.movie

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao {

    @Upsert
    suspend fun upsertMovieList(movieList:List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity WHERE id=:id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE category=:category")
    suspend fun getMovieListByCategory(category : String): List<MovieEntity>
}