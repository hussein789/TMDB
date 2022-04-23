package com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl

import com.hussien.tmdbshow.data.api.TMDBService
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowRemoteDataSource
import javax.inject.Inject

class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : TvShowRemoteDataSource {
    override suspend fun getTvShowsFromRemote(): List<TvShow> {
        return tmdbService.getPopularTvShows(apiKey).tvShows
    }
}