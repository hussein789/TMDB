package com.hussien.tmdbshow.presentation.movies

import androidx.lifecycle.*
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.domain.usecase.GetMoviesUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateMoviesUseCase
import kotlinx.coroutines.launch

class MoviesViewModel (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    private val _loadingState = MutableLiveData(false)
    val loadingState:LiveData<Boolean> get() = _loadingState

    private val _moviesState = MutableLiveData<List<Movie>>()
    val moviesState:LiveData<List<Movie>> get() = _moviesState
    init {
        getMovies()
    }



    fun getMovies(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val movieList = getMoviesUseCase.excute()
                movieList?.let { _moviesState.value = it }
            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }
    }

    fun updateMovies(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val movieList = updateMoviesUseCase.excute()
                movieList?.let { _moviesState.value = it }

            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }

    }
}