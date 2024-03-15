package com.example.moviesapp.movieList.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviesapp.movieList.presentation.components.MovieCard
import com.example.moviesapp.util.Category

@Composable
fun UpcomingMovieScreen(
    movieListState: MovieListState,
    navHostController: NavHostController,
    onEvent:(MovieListEvent) -> Unit
) {
    if(movieListState.upcomingMovieList.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(movieListState.upcomingMovieList.size){index->
                MovieCard(
                    movie = movieListState.upcomingMovieList[index],
                    navHostController = navHostController
                )
                Spacer(modifier = Modifier.height(10.dp))

                if(index>= movieListState.upcomingMovieList.size - 1 && !movieListState.isLoading){
                    onEvent(MovieListEvent.Paginate(category = Category.UPCOMING))
                }

            }
        }
    }

}