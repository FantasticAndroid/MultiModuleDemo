package com.multi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multi.database.dao.IMovieDao
import com.multi.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = DataBaseConst.DB_VERSION, exportSchema = false)
abstract class MultiModuleDataBase : RoomDatabase() {

    abstract fun getMovieDao(): IMovieDao
}