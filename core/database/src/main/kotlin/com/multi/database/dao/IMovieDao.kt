package com.multi.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.multi.database.entity.MovieEntity

@Dao
interface IMovieDao {

    @Insert
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Insert
    suspend fun insertMovieList(movieEntityList: List<MovieEntity>)

    @Query("SELECT * FROM ${MovieEntity.TABLE_MOVIE}")
    suspend fun getMovieList() : List<MovieEntity>

    @Query("SELECT * FROM ${MovieEntity.TABLE_MOVIE} WHERE ${MovieEntity.COLUMN_MOVIE_ID} = :id")
    suspend fun getMovie(id:Int) : MovieEntity

    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM ${MovieEntity.TABLE_MOVIE} WHERE ${MovieEntity.COLUMN_MOVIE_ID} = :id")
    suspend fun deleteMovie(id:Int)
}