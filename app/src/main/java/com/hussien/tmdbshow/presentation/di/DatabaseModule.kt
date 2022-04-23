package com.hussien.tmdbshow.presentation.di

import android.content.Context
import androidx.room.Room
import com.hussien.tmdbshow.data.db.ArtistDao
import com.hussien.tmdbshow.data.db.MovieDao
import com.hussien.tmdbshow.data.db.TMDBDatabase
import com.hussien.tmdbshow.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesTMDBDatabase(@ApplicationContext context:Context):TMDBDatabase{
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdb_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesMoviesDao(db:TMDBDatabase):MovieDao{
        return db.movieDao()
    }

    @Provides
    @Singleton
    fun providesArtistsDao(db:TMDBDatabase):ArtistDao{
        return db.artistDao()
    }

    @Provides
    @Singleton
    fun providesTvShowDao(db:TMDBDatabase):TvShowDao{
        return db.tvShowDao()
    }
}