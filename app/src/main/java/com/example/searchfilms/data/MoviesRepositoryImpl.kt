package com.example.searchfilms.data

import com.example.searchfilms.data.dto.MoviesSearchRequest
import com.example.searchfilms.data.dto.MoviesSearchResponse
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.util.Resource

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                Resource.Success((response as MoviesSearchResponse).results.map {
                    Movie(it.id, it.resultType, it.image, it.title, it.description)})
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}