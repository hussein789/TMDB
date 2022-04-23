package com.hussien.tmdbshow.data.repository.movie

import android.util.Log
import com.hussien.tmdbshow.data.model.movie.Movie
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieCacheDataSource
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieLocalDataSource
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieRemoteDataSource
import com.hussien.tmdbshow.domain.repository.MoviesRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MoviesRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val movies = getMoviesFromRemote()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(movies)
        movieCacheDataSource.saveMoviesToCache(movies)
        return movies
    }

    private suspend fun getMoviesFromRemote(): List<Movie> {
        var movies = ArrayList<Movie>()
        try {
            movies = movieRemoteDataSource.getMoviesFromRemote() as ArrayList<Movie>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        return movies
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        var movies = ArrayList<Movie>()
        try {
            movies = movieLocalDataSource.getMoviesFromDB() as ArrayList<Movie>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (movies.isEmpty()) {
            movies = getMoviesFromRemote() as ArrayList<Movie>
            movieLocalDataSource.saveMoviesToDB(movies)
        }
        return movies
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movies = ArrayList<Movie>()
        try {
            movies = movieCacheDataSource.getMoviesFromCache() as ArrayList<Movie>
        } catch (ex: Exception) {
            Log.d("tag", "something went wrong due to ${ex.message}")
        }
        if (movies.isEmpty()) {
            movies = getMoviesFromDB() as ArrayList<Movie>
            movieCacheDataSource.saveMoviesToCache(movies)
        }
        return movies
    }
}