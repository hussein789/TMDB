package com.hussien.tmdbshow.data.repository.tvshow.datasource

import com.hussien.tmdbshow.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
    suspend fun getTvShowsFromCache():List<TvShow>
}