package com.hussien.tmdbshow.domain.repository

import com.hussien.tmdbshow.data.model.movie.Movie

interface MoviesRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}