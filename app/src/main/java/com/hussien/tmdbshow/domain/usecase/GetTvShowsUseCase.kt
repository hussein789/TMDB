package com.hussien.tmdbshow.domain.usecase

import com.hussien.tmdbshow.domain.repository.TvShowsRepository
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(private val tvShowsRepository: TvShowsRepository) {
    suspend fun excute() = tvShowsRepository.getTvShows()
}