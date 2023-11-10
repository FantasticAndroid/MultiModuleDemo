package com.multi.movielist.ui

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.domain.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var getMovieListUseCase: GetMovieListUseCase

    suspend fun getMovieList(query: String): StateFlow<MovieListUIState> {
        return getMovieListUseCase(query = query).map {
            MovieListUIState.Success(it)
        }.stateIn(
            scope = viewModelScope,
            initialValue = MovieListUIState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
    }

    sealed interface MovieListUIState {
        object Loading : MovieListUIState

        @Keep
        data class Success(val movieList: List<Movie>?) : MovieListUIState
    }
}