package com.hussien.tmdbshow.domain.repository

import com.hussien.tmdbshow.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}