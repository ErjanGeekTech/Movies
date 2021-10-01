package com.example.movies.ui.fragments.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies.base.BaseViewModel
import com.example.movies.data.db.daos.MovieDao
import com.example.movies.data.network.apiservice.MovieApi
import com.example.movies.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val service: MovieApi,
    private val movieDao: MovieDao
) : BaseViewModel() {
    val moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            service.getMovies().let {
                if (it.isSuccessful) {
                    moviesList.postValue(it.body())
                    it.body()?.let { it1 -> movieDao.insert(it1) }
                } else Log.e("anime", "Error code: ${it.code()}")
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

    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            moviesList.postValue(movieDao.getStudents())
        }
    }
}