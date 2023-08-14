package com.example.searchfilms.di

import com.example.searchfilms.presentation.details.AboutViewModel
import com.example.searchfilms.presentation.details.PosterViewModel
import com.example.searchfilms.presentation.movies.MoviesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MoviesViewModel(androidContext(), get())
    }

    viewModel {(movieId: String) ->
        AboutViewModel(movieId, get())
    }

    viewModel {(posterUrl: String) ->
        PosterViewModel(posterUrl)
    }

}