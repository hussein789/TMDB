package com.hussien.tmdbshow.data.repository.movie.datasource

import com.hussien.tmdbshow.data.model.movie.Movie

interface MovieRemoteDataSource {
    suspend fun getMoviesFromRemote():List<Movie>
}