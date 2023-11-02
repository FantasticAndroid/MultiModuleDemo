package com.multi.movielist.data.repo

import com.core.network.services.movieservice.datasource.IMovieDataSource
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.domain.repo.IMovieListRepo
import mapToDomain
import javax.inject.Inject

class MovieListRepo @Inject constructor(private val movieDataSource: IMovieDataSource) :
    IMovieListRepo {
    override suspend fun getMovieList(query: String): List<Movie>? {
        return movieDataSource.getMovieList(query).mapToDomain()
    }
}