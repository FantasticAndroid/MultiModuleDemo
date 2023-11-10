import com.core.network.services.movieservice.model.MovieDTO
import com.core.network.services.movieservice.model.MovieListResponse
import com.multi.database.entity.MovieEntity
import com.multi.movielist.domain.model.Movie

fun MovieListResponse.mapToDomain(): List<Movie>? {

    return results?.map {
        Movie(it.originalTitle, it.posterPath)
    }
}

fun MovieEntity.mapToDomain(): Movie {
    return Movie(title = title, imageUrl = posterPath)
}

fun MovieDTO.mapToEntity(): MovieEntity {
    return MovieEntity(
        originalTitle = originalTitle,
        video = video, title = title, posterPath = posterPath,
        releaseDate = releaseDate, adult = adult
    )
}