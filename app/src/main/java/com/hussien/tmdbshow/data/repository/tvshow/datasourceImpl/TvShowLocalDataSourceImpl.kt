package com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl

import com.hussien.tmdbshow.data.db.TvShowDao
import com.hussien.tmdbshow.data.model.tvshow.TvShow
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvShowLocalDataSourceImpl @Inject constructor(
    private val tvShowDao: TvShowDao
) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}