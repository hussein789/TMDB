package com.hussien.tmdbshow.data.repository.movie.datasource

import com.hussien.tmdbshow.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}