package com.hussien.tmdbshow.data.repository.tvshow.datasource

import com.hussien.tmdbshow.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}