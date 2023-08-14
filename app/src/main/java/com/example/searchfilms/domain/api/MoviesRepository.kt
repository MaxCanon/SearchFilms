package com.example.searchfilms.domain.api

import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.domain.models.MovieCast
import com.example.searchfilms.domain.models.MovieDetails
import com.example.searchfilms.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
    fun getMovieDetails(movieId: String): Resource<MovieDetails>
    fun getMovieCast(movieId: String): Resource<MovieCast>
}