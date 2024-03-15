package com.example.moviesapp.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Upcoming
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.movieList.presentation.MovieListEvent
import com.example.moviesapp.movieList.presentation.MovieListViewModel
import com.example.moviesapp.movieList.presentation.PopularMovieScreen
import com.example.moviesapp.movieList.presentation.UpcomingMovieScreen
import com.example.moviesapp.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val movieListViewModel:MovieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieListState = movieListViewModel.movieListState.collectAsState().value
    val bottomNavController = rememberNavController()

    Scaffold(
       topBar = {
                TopAppBar(
                    title = {
                    Text(text = if (movieListState.isCurrentPopularScreen) "Popular Movies" else "Upcoming Movies")
                },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        MaterialTheme.colorScheme.inverseOnSurface
                    )
                )

       } ,
        bottomBar = {
            BottomNavBar(
                bottomNavController = bottomNavController,
                onEvent = movieListViewModel::onEvent
            )
        }

    ) {padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)){
            NavHost(navController = bottomNavController, startDestination = Screen.PopularMovieList.route){
                composable(Screen.PopularMovieList.route){
                    PopularMovieScreen(movieListState = movieListState, navHostController = navController, onEvent = movieListViewModel::onEvent )

                }
                composable(Screen.UpcomingMovieList.route){
                    UpcomingMovieScreen(movieListState = movieListState, navHostController = navController, onEvent = movieListViewModel::onEvent )


                }
            }

        }

    }

}

@Composable
fun BottomNavBar(
    bottomNavController: NavHostController,onEvent:(MovieListEvent)->Unit
) {
    val navItems = listOf(
        NavbarItem(
            title = "Popular",
            icon = Icons.Rounded.Movie
        ),
        NavbarItem(
            title = "Upcoming",
            icon = Icons.Rounded.Upcoming
        )
    )
    val selected = rememberSaveable{
        mutableIntStateOf(0)
    }
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            navItems.forEachIndexed { index, navbarItem ->
                NavigationBarItem(
                    selected = selected.intValue==index,
                    onClick = {
                              selected.intValue = index
                        when(selected.intValue){
                            0 ->{
                                onEvent(MovieListEvent.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate(Screen.PopularMovieList.route)
                            }
                            1 ->{
                                onEvent(MovieListEvent.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate(Screen.UpcomingMovieList.route)

                            }
                        }

                    },
                    icon = {
                        Icon(
                            imageVector = navbarItem.icon,
                            contentDescription = navbarItem.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(text = navbarItem.title , color = MaterialTheme.colorScheme.onBackground)
                    }
                )
            }

        }
    }




}

data class NavbarItem(
    val title: String,
    val icon: ImageVector
)