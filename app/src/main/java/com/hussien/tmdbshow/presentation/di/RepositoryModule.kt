package com.hussien.tmdbshow.presentation.di

import com.hussien.tmdbshow.data.repository.artist.ArtistRepositoryImpl
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistCacheDataSource
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistLocalDataSource
import com.hussien.tmdbshow.data.repository.artist.datasource.ArtistRemoteDataSource
import com.hussien.tmdbshow.data.repository.movie.MovieRepositoryImpl
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieCacheDataSource
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieLocalDataSource
import com.hussien.tmdbshow.data.repository.movie.datasource.MovieRemoteDataSource
import com.hussien.tmdbshow.data.repository.tvshow.TvShowRepositoryImpl
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.hussien.tmdbshow.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.hussien.tmdbshow.domain.repository.ArtistRepository
import com.hussien.tmdbshow.domain.repository.MoviesRepository
import com.hussien.tmdbshow.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMoviesRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun providesArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun providesTvShowsRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}