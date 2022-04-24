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

    @Provides
    fun providesMoviesCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Provides
    fun providesArtistsCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Provides
    fun providesTvShowsCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}