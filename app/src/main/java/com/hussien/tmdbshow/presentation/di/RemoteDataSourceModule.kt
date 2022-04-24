package com.hussien.tmdbshow.presentation.di

import com.hussien.tmdbshow.BuildConfig
import com.hussien.tmdbshow.data.api.TMDBService
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistRemoteDataSource
import com.hussien.tmdbshow.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieRemoteDataSource
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule() {

    @Provides
    fun providesMoviesRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Provides
    fun providesArtistsRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Provides
    fun providesTvShowsRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }
}