import com.example.searchfilms.presentation.poster.PosterView

class PosterPresenter(
    private val view: PosterView,
    private val imageUrl: String,
) {

    fun onCreate() {
        view.setupPosterImage(imageUrl)
    }
}