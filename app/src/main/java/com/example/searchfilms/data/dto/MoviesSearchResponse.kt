package com.example.searchfilms.data.dto

import com.example.searchfilms.domain.models.Movie


class MoviesSearchResponse(val searchType: String,
                           val expression: String,
                           val results: List<Movie>) : Response()