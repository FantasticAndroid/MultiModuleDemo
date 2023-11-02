package com.core.network.services.movieservice.datasource

import com.core.network.IApiService
import com.core.network.services.movieservice.model.MovieListResponse
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val apiService: IApiService) :
    IMovieDataSource {
    override suspend fun getMovieList(query: String): MovieListResponse {
        return apiService.getMovieList(queryString = query)
    }
}