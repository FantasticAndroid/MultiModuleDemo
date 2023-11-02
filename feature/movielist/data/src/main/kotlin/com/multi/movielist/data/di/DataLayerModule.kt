package com.multi.movielist.data.di

import com.multi.movielist.data.repo.MovieListRepo
import com.multi.movielist.domain.repo.IMovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class DataLayerModule {

    @Binds
    abstract fun bindMovieListRepo(movieListRepo: MovieListRepo): IMovieListRepo
}