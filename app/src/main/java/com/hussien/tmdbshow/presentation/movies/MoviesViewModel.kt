package com.hussien.tmdbshow.presentation.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hussien.tmdbshow.domain.usecase.GetMoviesUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateMoviesUseCase

class MoviesViewModel (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    val loading = MutableLiveData<Boolean>(false)

    init {
        getMovies()
    }

    fun getMovies() = liveData {
        loading.value = true
        val movies = getMoviesUseCase.excute()
        emit(movies)
        loading.value = false
    }

    fun updateMovies() = liveData{
        loading.value = true
        val movies = updateMoviesUseCase.excute()
        emit(movies)
        loading.value = false
    }
}