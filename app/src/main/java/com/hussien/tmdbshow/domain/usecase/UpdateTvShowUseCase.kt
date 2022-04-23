package com.hussien.tmdbshow.domain.usecase

import com.hussien.tmdbshow.domain.repository.TvShowsRepository
import javax.inject.Inject

class UpdateTvShowUseCase @Inject constructor(private val tvShowsRepository: TvShowsRepository) {
    suspend fun excute() = tvShowsRepository.updateTvShows()
}