package com.example.movies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.data.db.converter.Converters
import com.example.movies.data.db.daos.MovieDao
import com.example.movies.models.Movie

@Database(entities = arrayOf(Movie::class), version = 11)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}