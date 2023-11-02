package com.core.network.services.movieservice.datasource

import com.core.network.services.movieservice.model.MovieListResponse

interface IMovieDataSource {

    suspend fun getMovieList(query:String) : MovieListResponse
}