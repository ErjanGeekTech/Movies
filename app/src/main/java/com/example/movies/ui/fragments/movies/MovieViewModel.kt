package com.example.movies.ui.fragments.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movies.base.BaseViewModel
import com.example.movies.data.network.apiservice.MovieApi
import com.example.movies.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val service: MovieApi) : BaseViewModel() {
    val moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovies() {
        uiScope.launch {
            service.getMovies().let {
                if (it.isSuccessful) moviesList.postValue(it.body())
                else Log.e("anime", "Error code: ${it.code()}")
            }
        }
    }

    fun fetchMovie(id: Int) {
        uiScope.launch {
            service.movie(id).let {
                if (it.isSuccessful) movie.postValue(it.body())
                else Log.e("anime", "Error code: ${it.code()}")
            }
        }
    }
}