package com.example.movies.data.db

import android.content.Context
import androidx.room.Room
import com.example.movies.data.db.daos.MovieDao

class RoomClient {
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "movie.db"
        ).fallbackToDestructiveMigration().build()
    }


    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }
}