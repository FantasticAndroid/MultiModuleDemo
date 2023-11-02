package com.core.network.di

import com.core.network.services.movieservice.datasource.IMovieDataSource
import com.core.network.services.movieservice.datasource.MovieDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Bind all data sources here
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun MovieDataSource(movieDataSource: MovieDataSource): IMovieDataSource
}