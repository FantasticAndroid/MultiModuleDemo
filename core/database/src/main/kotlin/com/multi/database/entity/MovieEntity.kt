package com.multi.database.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = MovieEntity.TABLE_MOVIE)
data class MovieEntity(

    @ColumnInfo("original_title")
    val originalTitle: String? = null,

    @ColumnInfo("video")
    val video: Boolean?,

    @ColumnInfo("title")
    val title: String? = null,

    @ColumnInfo("poster_path")
    val posterPath: String? = null,

    @ColumnInfo("release_date")
    val releaseDate: String? = null,

    @ColumnInfo(COLUMN_MOVIE_ID)
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo("adult")
    val adult: Boolean?,
) {
    companion object {
        const val TABLE_MOVIE = "Movie"
        const val COLUMN_MOVIE_ID = "movieId"
    }
}
