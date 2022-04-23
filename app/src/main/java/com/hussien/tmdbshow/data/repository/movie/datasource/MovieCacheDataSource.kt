package com.hussien.tmdbshow.data.repository.movie.datasource

import com.hussien.tmdbshow.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies:List<Movie>)
    suspend fun getMoviesFromCache():List<Movie>
}