package com.example.animeapp.data.remote.api

import com.example.animeapp.data.remote.dto.AnimeDetailDto
import com.example.animeapp.data.remote.dto.AnimeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApiService {
    @GET("anime")
    suspend fun searchAnime(@Query("q") query: String): AnimeSearchResponse

    @GET("anime/{id}/full")
    suspend fun getAnimeFullById(@Path("id") id: Int): AnimeDetailDto
}