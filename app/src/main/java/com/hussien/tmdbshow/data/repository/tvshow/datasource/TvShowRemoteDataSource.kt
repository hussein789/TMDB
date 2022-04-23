package com.hussien.tmdbshow.data.repository.tvshow.datasource

import com.hussien.tmdbshow.data.model.tvshow.TvShow

interface TvShowRemoteDataSource {

    suspend fun getTvShowsFromRemote():List<TvShow>
}