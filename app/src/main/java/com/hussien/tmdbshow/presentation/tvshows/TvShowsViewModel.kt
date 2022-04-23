package com.hussien.tmdbshow.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hussien.tmdbshow.domain.usecase.GetTvShowsUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateTvShowUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.excute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowUseCase.excute()
        emit(tvShows)
    }
}