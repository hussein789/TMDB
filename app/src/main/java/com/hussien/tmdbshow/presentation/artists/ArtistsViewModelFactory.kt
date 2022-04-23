package com.hussien.tmdbshow.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussien.tmdbshow.domain.usecase.GetArtistUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateArtistUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ArtistsViewModelFactory @Inject constructor(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ArtistsViewModel::class.java))
            return ArtistsViewModel(getArtistUseCase,updateArtistUseCase) as T
        throw IllegalArgumentException("unknow view model found")
    }
}