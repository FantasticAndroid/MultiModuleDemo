package com.core.network

import com.core.network.services.movieservice.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET(Constant.MOVIE_SEARCH_API)
    suspend fun getMovieList(
        @Query("query") queryString: String,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): MovieListResponse
}