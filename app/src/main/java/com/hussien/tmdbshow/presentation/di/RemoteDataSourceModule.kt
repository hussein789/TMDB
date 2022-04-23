package com.hussien.tmdbshow.presentation.di

import com.hussien.tmdbshow.BuildConfig
import com.hussien.tmdbshow.data.api.TMDBService
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistRemoteDataSource
import com.hussien.tmdbshow.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieRemoteDataSource
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule() {

    @Provides
    @Singleton
    fun providesMoviesRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Provides
    @Singleton
    fun providesArtistsRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Provides
    @Singleton
    fun providesTvShowsRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }
}