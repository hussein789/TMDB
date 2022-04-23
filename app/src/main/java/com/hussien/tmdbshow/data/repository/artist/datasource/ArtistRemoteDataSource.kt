package com.hussien.tmdbshow.data.repository.artist.datasource

import com.hussien.tmdbshow.data.model.artist.Artist

interface ArtistRemoteDataSource {

    suspend fun getArtistFromRemote():List<Artist>
}