package com.hussien.tmdbshow.data.api


import com.hussien.tmdbshow.data.model.artist.ArtistList
import com.hussien.tmdbshow.data.model.movie.MovieList
import com.hussien.tmdbshow.data.model.tvshow.TvShowList
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String
    ): MovieList

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey:String
    ): TvShowList

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apiKey:String
    ): ArtistList
}