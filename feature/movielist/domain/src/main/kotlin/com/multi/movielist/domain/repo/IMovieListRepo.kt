package com.multi.movielist.domain.repo

import com.multi.movielist.domain.model.Movie

interface IMovieListRepo {

    suspend fun getMovieList(query: String): List<Movie>?
}