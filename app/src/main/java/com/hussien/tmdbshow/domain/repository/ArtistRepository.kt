package com.hussien.tmdbshow.domain.repository

import com.hussien.tmdbshow.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}