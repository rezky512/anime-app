package com.example.animeapp.domain.repository

import com.example.animeapp.domain.model.Anime

interface AnimeRepository {
    suspend fun searchAnime(query: String): List<Anime>
    suspend fun getAnimeDetailById(id: Int): Anime?
}