package com.multi.movielist.domain.usecases

import com.core.common.UiEvent
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.domain.repo.IMovieListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val iMovieListRepo: IMovieListRepo) {
    operator fun invoke(query: String) {
        flow<UiEvent<List<Movie>?>> {
            emit(UiEvent.Loading())
            emit(UiEvent.Success(data = iMovieListRepo.getMovieList(query)))
        }.catch { emit(UiEvent.Error(it.message.toString())) }
            .flowOn(Dispatchers.IO)
    }
}