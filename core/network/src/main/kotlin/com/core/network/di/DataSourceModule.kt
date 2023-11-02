package com.core.network.di

import com.core.network.services.movieservice.datasource.IMovieDataSource
import com.core.network.services.movieservice.datasource.MovieDataSource
import dagger.Binds
import dagger.Module

/**
 * Bind all data sources here
 */
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun MovieDataSource(movieDataSource: MovieDataSource) : IMovieDataSource
}