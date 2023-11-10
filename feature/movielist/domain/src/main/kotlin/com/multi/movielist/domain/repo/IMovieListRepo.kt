package com.multi.movielist.domain.repo

import com.multi.movielist.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieListRepo {

    // For Flow method would not be suspended
    fun getMovieList(query: String): Flow<List<Movie>?>

    //suspend fun getMovieList(query: String): List<Movie>?>
}