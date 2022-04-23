package com.hussien.tmdbshow.data.repository.movie.datasourceImpl

import com.hussien.tmdbshow.data.api.TMDBService
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMoviesFromRemote(): List<Movie> {
        return tmdbService.getPopularMovies(apiKey).movies
    }
}