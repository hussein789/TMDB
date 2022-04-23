package com.hussien.tmdbshow.data.repository.artist

import android.util.Log
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistCacheDataSource
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistLocalDataSource
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistRemoteDataSource
import com.hussien.tmdbshow.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val artists = getArtistsFromRemote()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(artists)
        artistCacheDataSource.saveArtistToCache(artists)
        return artists
    }

    private suspend fun getArtistsFromRemote(): List<Artist> {
        var artists = ArrayList<Artist>()
        try {
            artists = artistRemoteDataSource.getArtistFromRemote() as ArrayList<Artist>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        return artists
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        var artists = ArrayList<Artist>()
        try {
            artists = artistLocalDataSource.getArtistFromDB() as ArrayList<Artist>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (artists.isEmpty()) {
            artists = getArtistsFromRemote() as ArrayList<Artist>
            artistLocalDataSource.saveArtistToDB(artists)
        }
        return artists
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        var artists = ArrayList<Artist>()
        try {
            artists = artistCacheDataSource.getArtistFromCache() as ArrayList<Artist>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (artists.isEmpty()) {
            artists = getArtistsFromDB() as ArrayList<Artist>
            artistCacheDataSource.saveArtistToCache(artists)
        }
        return artists
    }
}