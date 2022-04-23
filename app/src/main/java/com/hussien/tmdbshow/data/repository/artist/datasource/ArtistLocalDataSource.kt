package com.hussien.tmdbshow.data.repository.artist.datasource

import com.hussien.tmdbshow.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(artists:List<Artist>)
    suspend fun clearAll()
}