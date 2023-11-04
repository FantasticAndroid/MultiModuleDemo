package com.multi.database.di

import android.content.Context
import androidx.room.Room
import com.multi.database.DataBaseConst
import com.multi.database.MultiModuleDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun ProvideMultiModuleDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context, MultiModuleDataBase::class.java,
            DataBaseConst.DB_NAME
        )
            // To Recreate DB if Migration Fail
            .fallbackToDestructiveMigration()
            //.addTypeConverter()
            // Optional
            .setQueryCallback(
                { sqlQuery, bindArgs ->
                    println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                }, Executors.newSingleThreadExecutor()
            )
            .build()
}