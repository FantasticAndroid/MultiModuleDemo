package com.multi.movielist.domain.usecases

import com.multi.movielist.domain.model.Movie
import com.multi.movielist.domain.repo.IMovieListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val iMovieListRepo: IMovieListRepo) {

    operator fun invoke(query: String): Flow<List<Movie>?> {
        return iMovieListRepo.getMovieList(query)
    }
}