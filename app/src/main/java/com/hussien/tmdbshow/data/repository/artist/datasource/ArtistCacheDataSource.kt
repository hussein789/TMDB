package com.hussien.tmdbshow.data.repository.artist.datasource

import com.hussien.tmdbshow.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun saveArtistToCache(artists:List<Artist>)
    suspend fun getArtistFromCache():List<Artist>
}