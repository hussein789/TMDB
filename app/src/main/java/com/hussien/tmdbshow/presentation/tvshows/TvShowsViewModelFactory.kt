package com.hussien.tmdbshow.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussien.tmdbshow.domain.usecase.GetTvShowsUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateTvShowUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class TvShowsViewModelFactory @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TvShowsViewModel::class.java))
            return TvShowsViewModel(getTvShowsUseCase,updateTvShowUseCase) as T
        throw IllegalArgumentException("unknown view model found")
    }
}