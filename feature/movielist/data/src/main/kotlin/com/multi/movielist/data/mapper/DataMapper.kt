import com.core.network.services.movieservice.model.MovieListResponse
import com.multi.movielist.domain.model.Movie

fun MovieListResponse.mapToDomain(): List<Movie>? {

    return results?.map {
        Movie(it.originalTitle, it.posterPath)
    }
}