package com.hussien.tmdbshow.presentation.di
//
//import com.hussien.tmdbshow.domain.repository.ArtistRepository
//import com.hussien.tmdbshow.domain.repository.MoviesRepository
//import com.hussien.tmdbshow.domain.repository.TvShowsRepository
//import com.hussien.tmdbshow.domain.usecase.*
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//class UseCaseModule {
//
//    @Provides
//    fun providesGetMoviesUseCase(moviesRepository: MoviesRepository):GetMoviesUseCase{
//        return GetMoviesUseCase(moviesRepository)
//    }
//
//    @Provides
//    fun providesUpdateMoviesUseCase(moviesRepository: MoviesRepository):UpdateMoviesUseCase{
//        return UpdateMoviesUseCase(moviesRepository)
//    }
//
//    @Provides
//    fun providesGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
//        return GetArtistUseCase(artistRepository)
//    }
//
//    @Provides
//    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
//        return UpdateArtistUseCase(artistRepository)
//    }
//
//    @Provides
//    fun providesGetTvShowsUseCase(tvShowsRepository: TvShowsRepository):GetTvShowsUseCase{
//        return GetTvShowsUseCase(tvShowsRepository)
//    }
//
//    @Provides
//    fun providesUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository):UpdateTvShowUseCase{
//        return UpdateTvShowUseCase(tvShowsRepository)
//    }
//}