package com.hussien.tmdbshow.presentation.di

import com.hussien.tmdbshow.data.db.ArtistDao
import com.hussien.tmdbshow.data.db.MovieDao
import com.hussien.tmdbshow.data.db.TvShowDao
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistLocalDataSource
import com.hussien.tmdbshow.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieLocalDataSource
import com.hussien.tmdbshow.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Provides
    fun providesArtistsLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Provides
    fun providesTvShowsLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}