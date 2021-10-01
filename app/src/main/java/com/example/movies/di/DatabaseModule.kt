package com.example.movies.di

import android.content.Context
import com.example.movies.data.db.AppDatabase
import com.example.movies.data.db.RoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    val roomClient = RoomClient()

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context) = roomClient.provideRoom(context)

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase) = roomClient.provideMovieDao(appDatabase)
}