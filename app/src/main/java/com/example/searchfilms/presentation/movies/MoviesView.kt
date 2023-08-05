package com.example.searchfilms.presentation.movies

import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.ui.movies.models.MoviesState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MoviesView : MvpView {

    // Методы, меняющие внешний вид экрана

    // Состояние «загрузки»
    fun showLoading()

    // Состояние «ошибки»
    fun showError(errorMessage: String)

    // Состояние «пустого списка»
    fun showEmpty(emptyMessage: String)

    // Состояние «контента»
    fun showContent(movies: List<Movie>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: MoviesState)

    // Методы «одноразовых событий»

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(additionalMessage: String)

    fun showPlaceholderMessage(isVisible: Boolean)

    fun showMoviesList(isVisible: Boolean)

    fun showProgressBar(isVisible: Boolean)

    fun changePlaceholderText(newPlaceholderText: String)

    fun updateMoviesList(newMoviesList: List<Movie>)

    // Методы «одноразовых событий»
    fun showMessage(message: String)
}