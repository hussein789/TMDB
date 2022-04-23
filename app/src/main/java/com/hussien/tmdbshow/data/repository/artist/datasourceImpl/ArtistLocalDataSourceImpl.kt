package com.hussien.tmdbshow.data.repository.artist.datasourceImpl

import com.hussien.tmdbshow.data.db.ArtistDao
import com.hussien.tmdbshow.data.model.artist.Artist
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistLocalDataSourceImpl @Inject constructor(
    private val artistDao: ArtistDao
): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}