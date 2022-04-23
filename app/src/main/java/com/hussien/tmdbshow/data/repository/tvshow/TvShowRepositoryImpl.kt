package com.hussien.tmdbshow.data.repository.tvshow

import android.util.Log
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.hussien.tmdbshow.domain.repository.TvShowsRepository
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvShows = getTvShowFromRemote()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(tvShows)
        tvShowCacheDataSource.saveTvShowsToCache(tvShows)
        return tvShows
    }

    private suspend fun getTvShowFromRemote(): List<TvShow> {
        var tvShows = ArrayList<TvShow>()
        try {
            tvShows = tvShowRemoteDataSource.getTvShowsFromRemote() as ArrayList<TvShow>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        return tvShows
    }

    private suspend fun getTvShowFromDB(): List<TvShow> {
        var tvShows = ArrayList<TvShow>()
        try {
            tvShows = tvShowLocalDataSource.getTvShowsFromDB() as ArrayList<TvShow>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (tvShows.isEmpty()) {
            tvShows = getTvShowFromRemote() as ArrayList<TvShow>
            tvShowLocalDataSource.saveTvShowsToDB(tvShows)
        }
        return tvShows
    }

    private suspend fun getTvShowFromCache(): List<TvShow> {
        var tvShows = ArrayList<TvShow>()
        try {
            tvShows = tvShowCacheDataSource.getTvShowsFromCache() as ArrayList<TvShow>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (tvShows.isEmpty()) {
            tvShows = getTvShowFromDB() as ArrayList<TvShow>
            tvShowCacheDataSource.saveTvShowsToCache(tvShows)
        }
        return tvShows
    }
}