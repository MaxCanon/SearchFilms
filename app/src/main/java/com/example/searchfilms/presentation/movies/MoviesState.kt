package com.example.searchfilms.presentation.movies

import com.example.searchfilms.domain.models.Movie

sealed interface MoviesState {

    object Loading : MoviesState

    data class Content(
        val movies: List<Movie>
    ) : MoviesState

    data class Error(
        val message: String
    ) : MoviesState

    data class Empty(
        val message: String
    ) : MoviesState

}