package com.hussien.tmdbshow.data.repository.artist.datasourceImpl

import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = mutableListOf<Artist>()

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }
}