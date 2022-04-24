package com.hussien.tmdbshow.data.repository.artist.datasourceImpl

import com.hussien.tmdbshow.data.api.TMDBService
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistRemoteDataSource
import javax.inject.Inject

class ArtistRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDataSource {
    override suspend fun getArtistFromRemote(): List<Artist> {
        return tmdbService.getPopularArtists(apiKey).artists
    }
}