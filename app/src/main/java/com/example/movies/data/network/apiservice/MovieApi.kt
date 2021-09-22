package com.example.movies.data.network.apiservice

import com.example.movies.models.Movie
import com.example.movies.utils.Constants.END_POINT_SHOWS
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET(END_POINT_SHOWS)
    suspend fun getMovies(): Response<List<Movie>>

    @GET("shows/{id}")
    suspend fun movie(
        @Path("id") id: Int
    ): Response<Movie>

}