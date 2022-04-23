package com.hussien.tmdbshow.domain.usecase

import com.hussien.tmdbshow.domain.repository.MoviesRepository
import javax.inject.Inject

class UpdateMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend fun excute() = moviesRepository.updateMovies()
}