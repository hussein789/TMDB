package com.hussien.tmdbshow.data.repository.movie.datasourceImpl

import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = mutableListOf<Movie>()

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}