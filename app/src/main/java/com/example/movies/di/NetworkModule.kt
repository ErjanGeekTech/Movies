package com.example.movies.di

import com.example.movies.data.network.RetrofitClient
import com.example.movies.data.network.apiservice.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun fetchMovie(): MovieApi {
        return retrofitClient.provideMoviesApiService()
    }

}