package com.example.moviesapp.di

import com.example.moviesapp.movieList.data.repository.MovieListRepositoryImpl
import com.example.moviesapp.movieList.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositroyModule{

    @Binds
    @Singleton
    abstract fun provideMovieListRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl
    ):MovieListRepository

}