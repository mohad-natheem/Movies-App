package com.example.moviesapp.movieList.presentation

sealed interface MovieListEvent {
    data class Paginate(val category: String):MovieListEvent
    object Navigate: MovieListEvent
}