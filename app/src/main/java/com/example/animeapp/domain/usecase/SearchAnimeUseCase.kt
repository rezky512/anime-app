package com.example.animeapp.domain.usecase

import com.example.animeapp.domain.model.Anime
import com.example.animeapp.domain.repository.AnimeRepository

class SearchAnimeUseCase(
    private val repository: AnimeRepository
) {
    suspend operator fun invoke(query: String): List<Anime> {
        return repository.searchAnime(query)
    }
}