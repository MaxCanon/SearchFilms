package com.example.searchfilms.presentation.movies


import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import com.example.searchfilms.R
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.ui.movies.MoviesState
import com.example.searchfilms.util.Creator

class MoviesSearchPresenter(
    private val view: MoviesView,
    private val context: Context,
) {

    companion object {
        private const val SEARCH_DEBOUNCE_DELAY = 2000L
        private val SEARCH_REQUEST_TOKEN = Any()
    }

    private val moviesInteractor = Creator.provideMoviesInteractor(context)

    private val movies = ArrayList<Movie>()

    private val handler = Handler(Looper.getMainLooper())

    fun onDestroy() {
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)
    }

    fun searchDebounce(changedText: String) {
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)

        val searchRunnable = Runnable { searchRequest(changedText) }

        val postTime = SystemClock.uptimeMillis() + SEARCH_DEBOUNCE_DELAY
        handler.postAtTime(
            searchRunnable,
            SEARCH_REQUEST_TOKEN,
            postTime,
        )
    }

    private fun searchRequest(newSearchText: String) {
        if (newSearchText.isNotEmpty()) {
            view.render(
                MoviesState.Loading
            )

            moviesInteractor.searchMovies(newSearchText, object : MoviesInteractor.MoviesConsumer {
                override fun consume(foundMovies: List<Movie>?, errorMessage: String?) {
                    handler.post {
                        if (foundMovies != null) {
                            movies.clear()
                            movies.addAll(foundMovies)
                        }

                        when {
                            errorMessage != null -> {
                                view.render(
                                    MoviesState.Error(
                                        errorMessage = context.getString(R.string.something_went_wrong),
                                    )
                                )
                                view.showToast(errorMessage)
                            }

                            movies.isEmpty() -> {
                                view.render(
                                    MoviesState.Empty(
                                        message = context.getString(R.string.nothing_found),
                                    )
                                )
                            }

                            else -> {
                                view.render(
                                    MoviesState.Content(
                                        movies = movies,
                                    )
                                )
                            }
                        }

                    }
                }
            })
        }
    }

}




