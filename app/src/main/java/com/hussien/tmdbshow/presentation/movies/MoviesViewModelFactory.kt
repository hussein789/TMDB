package com.hussien.tmdbshow.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussien.tmdbshow.domain.usecase.GetMoviesUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateMoviesUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesViewModel::class.java))
            return MoviesViewModel(getMoviesUseCase,updateMoviesUseCase) as T
        throw IllegalArgumentException("unknown view model found")
    }
}