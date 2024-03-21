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
import com.example.moviesapp.movieList.domain.model.Movie
import com.example.moviesapp.movieList.presentation.MovieListEvent
import com.example.moviesapp.movieList.presentation.MovieListState
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

val movieListState1 = MovieListState(
    upcomingMovieList = listOf(
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
    ),
    popularMovieList = listOf(
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
        Movie(
            adult = false,
            backdrop_path = "/gJL5kp5FMopB2sN4WZYnNT5uO0u.jpg",
            genre_ids =
            listOf(
                28,
                12,
                16,
                35,
                10751
            ),
            id = 1011985,
            original_language = "en",
            original_title = "Kung Fu Panda 4",
            overview = "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
            popularity = 3781.812,
            poster_path = "/wkfG7DaExmcVsGLR4kLouMwxeT5.jpg",
            release_date = "2024-03-02",
            title = "Kung Fu Panda 4",
            video = false,
            vote_average = 6.9,
            vote_count = 157,
            category = "popular"
        ),
    ),
)
