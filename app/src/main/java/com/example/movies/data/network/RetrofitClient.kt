package com.example.movies.data.network

import com.example.movies.data.network.apiservice.MovieApi
import com.example.movies.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideMoviesApiService(): MovieApi{
        return retrofit.create(MovieApi::class.java)
    }

}