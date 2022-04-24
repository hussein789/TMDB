package com.hussien.tmdbshow.presentation.artists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.domain.usecase.GetArtistUseCase
import com.hussien.tmdbshow.domain.usecase.UpdateArtistUseCase
import kotlinx.coroutines.launch

class ArtistsViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    private val _loadingState = MutableLiveData(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _artistsListState = MutableLiveData<List<Artist>>()
    val artistsListState: LiveData<List<Artist>> get() = _artistsListState
    init {
        getArtists()
    }


    fun getArtists(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val artists = getArtistUseCase.excute()
                artists?.let { _artistsListState.value = it }
            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }
    }

    fun updateArtists(){
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val artists = updateArtistUseCase.excute()
                artists?.let { _artistsListState.value = it }

            } catch (ex:Exception){

            } finally {
                _loadingState.value = false
            }
        }

    }
}