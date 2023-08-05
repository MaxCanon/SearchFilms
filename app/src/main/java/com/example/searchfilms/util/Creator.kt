package com.example.searchfilms.util

import android.content.Context
import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.network.RetrofitNetworkClient
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import com.example.searchfilms.presentation.movies.MoviesSearchViewModel
import com.example.searchfilms.presentation.poster.PosterPresenter
import com.example.searchfilms.presentation.poster.PosterView
import com.example.searchfilms.ui.movies.models.LocalStorage

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(
            RetrofitNetworkClient(context),
            LocalStorage(context.getSharedPreferences("local_storage", Context.MODE_PRIVATE)),
        )
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }


    fun providePosterPresenter(
        posterView: PosterView,
        imageUrl: String
    ): PosterPresenter {
        return PosterPresenter(posterView, imageUrl)
    }


}