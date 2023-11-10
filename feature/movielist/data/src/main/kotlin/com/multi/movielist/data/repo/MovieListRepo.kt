package com.multi.movielist.data.repo

import android.util.Log
import com.core.network.services.movieservice.datasource.IMovieDataSource
import com.multi.database.dao.IMovieDao
import com.multi.movielist.domain.model.Movie
import com.multi.movielist.domain.repo.IMovieListRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mapToDomain
import mapToEntity
import javax.inject.Inject

private const val TAG = "MovieListRepo"

class MovieListRepo @Inject constructor(
    private val movieDataSource: IMovieDataSource,
    private val movieDao: IMovieDao
) : IMovieListRepo {
    private suspend fun syncMovieList(query: String) {
        Log.d(TAG, "syncMovieList")
        val response = movieDataSource.getMovieList(query)
        Log.d(TAG, "syncMovieList response: $response")

        response?.results?.let { movieDtoList ->
            movieDao.insertMovieList(movieDtoList.map {
                it.mapToEntity()
            })
        }
    }

    override suspend fun getMovieList(query: String): Flow<List<Movie>?> {
        syncMovieList(query)
        return movieDao.getMovieList().map { it?.map { movieEntity -> movieEntity.mapToDomain() } }
    }
}