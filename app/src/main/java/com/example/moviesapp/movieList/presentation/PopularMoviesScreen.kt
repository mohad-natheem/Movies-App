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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.movieList.domain.model.Movie
import com.example.moviesapp.movieList.presentation.components.MovieCard
import com.example.moviesapp.util.Category

@Composable
fun PopularMovieScreen(
    movieListState: MovieListState,
    navHostController: NavHostController,
    onEvent: (MovieListEvent) -> Unit
) {
    if (movieListState.popularMovieList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(movieListState.popularMovieList.size) { index ->
                MovieCard(
                    movie = movieListState.popularMovieList[index],
                    navHostController = navHostController
                )
                Spacer(modifier = Modifier.height(10.dp))

                if (index >= movieListState.popularMovieList.size - 1 && !movieListState.isLoading) {
                    onEvent(MovieListEvent.Paginate(category = Category.POPULAR))
                }

            }
        }
    }

}

val movieListState = MovieListState(
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

@Preview
@Composable
fun PreviewPopularMovieScreen() {
    PopularMovieScreen(movieListState = movieListState, navHostController = rememberNavController() , onEvent = {})

}