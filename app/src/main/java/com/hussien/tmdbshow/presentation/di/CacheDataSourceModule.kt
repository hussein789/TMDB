package com.hussien.tmdbshow.presentation.di

import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistCacheDataSource
import com.hussien.tmdbshow.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieCacheDataSource
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun providesMoviesCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistsCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowsCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}