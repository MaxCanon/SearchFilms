package com.example.searchfilms.util

import com.example.searchfilms.presentation.poster.PosterPresenter
import android.content.Context
import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.network.RetrofitNetworkClient
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import com.example.searchfilms.presentation.poster.PosterView

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
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