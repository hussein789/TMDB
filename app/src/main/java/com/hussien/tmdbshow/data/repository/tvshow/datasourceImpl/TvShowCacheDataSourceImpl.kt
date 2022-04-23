package com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl

import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShows = mutableListOf<TvShow>()

    override suspend fun saveTvShowsToCache(list: List<TvShow>) {
        tvShows.clear()
        tvShows.addAll(list)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShows
    }
}