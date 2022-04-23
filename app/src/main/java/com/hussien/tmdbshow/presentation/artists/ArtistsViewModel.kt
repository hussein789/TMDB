package com.hussien.tmdbshow.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hussien.tmdbshow.domain.usecase.GetArtistUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateArtistUseCase

class ArtistsViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistUseCase.excute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistUseCase.excute()
        emit(artists)
    }
}