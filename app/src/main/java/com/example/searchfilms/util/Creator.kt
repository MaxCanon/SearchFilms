package com.example.searchfilms.util

import PosterPresenter
import android.content.Context
import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.network.RetrofitNetworkClient
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import com.example.searchfilms.presentation.movies.MoviesSearchPresenter
import com.example.searchfilms.presentation.movies.MoviesView
import com.example.searchfilms.presentation.poster.PosterView
import com.example.searchfilms.ui.movies.MoviesAdapter

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchPresenter(
        moviesView: MoviesView,
        context: Context,
        adapter: MoviesAdapter
    ): MoviesSearchPresenter {
        return MoviesSearchPresenter(
            view = moviesView,
            context = context,
            adapter = adapter
        )
    }

    fun providePosterPresenter(
        posterView: PosterView,
        imageUrl: String
    ): PosterPresenter {
        return PosterPresenter(posterView, imageUrl)
    }
}