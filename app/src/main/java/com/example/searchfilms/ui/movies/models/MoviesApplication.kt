package com.example.searchfilms.ui.movies.models

import android.app.Application
import com.example.searchfilms.presentation.movies.MoviesSearchViewModel

class MoviesApplication : Application() {

    var moviesSearchPresenter : MoviesSearchViewModel? = null

}