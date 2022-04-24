package com.hussien.tmdbshow.presentation.tvshows

import androidx.lifecycle.*
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.domain.usecase.GetTvShowsUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateTvShowUseCase
import kotlinx.coroutines.launch

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    private val _loadingState = MutableLiveData(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _TvShowsState = MutableLiveData<List<TvShow>>()
    val tvShowsState: LiveData<List<TvShow>> get() = _TvShowsState
    init {
        getTvShows()
    }

    fun getTvShows(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val movieList = getTvShowsUseCase.excute()
                movieList?.let { _TvShowsState.value = it }
            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }
    }

    fun updateTvShows(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val movieList = updateTvShowUseCase.excute()
                movieList?.let { _TvShowsState.value = it }

            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }
    }
}