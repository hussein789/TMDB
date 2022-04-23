package com.hussien.tmdbshow.domain.usecase

import com.hussien.tmdbshow.domain.repository.ArtistRepository
import javax.inject.Inject

class GetArtistUseCase @Inject constructor(private val artistRepository: ArtistRepository) {
    suspend fun excute() = artistRepository.getArtists()
}