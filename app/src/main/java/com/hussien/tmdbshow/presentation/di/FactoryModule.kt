package com.hussien.tmdbshow.presentation.di
//
//import com.hussien.tmdbshow.domain.usecase.*
//import com.hussien.tmdbshow.presentation.artists.ArtistsViewModelFactory
//import com.hussien.tmdbshow.presentation.movies.MoviesViewModelFactory
//import com.hussien.tmdbshow.presentation.tvshows.TvShowsViewModelFactory
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//class FactoryModule {
//
//    @Provides
//    fun providesMovieFactory(
//        getMoviesUseCase: GetMoviesUseCase,
//        updateMoviesUseCase: UpdateMoviesUseCase
//    ): MoviesViewModelFactory {
//        return MoviesViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
//    }
//
//    @Provides
//    fun providesArtistsViewModelFactory(
//        getArtistUseCase: GetArtistUseCase,
//        updateArtistUseCase: UpdateArtistUseCase
//    ): ArtistsViewModelFactory {
//        return ArtistsViewModelFactory(getArtistUseCase, updateArtistUseCase)
//    }
//
//    @Provides
//    fun providesTvShowsViewModelFactory(
//        getTvShowsUseCase: GetTvShowsUseCase,
//        updateTvShowUseCase: UpdateTvShowUseCase
//    ): TvShowsViewModelFactory {
//        return TvShowsViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
//    }
//}