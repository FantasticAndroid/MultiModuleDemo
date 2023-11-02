package com.multi.movielist.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MovieListViewModel : ViewModel() {

    /*@Inject
    lateinit var getMovieListUseCase: Lazy<GetMovieListUseCase>

    fun getMovieList(query: String) = getMovieListUseCase.get().invoke(query)*/
}