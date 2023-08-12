package com.example.searchfilms.ui.movies

import android.app.Application
import com.example.searchfilms.presentation.movies.MoviesSearchPresenter

class MoviesApplication : Application() {

    var moviesSearchPresenter : MoviesSearchPresenter? = null

}