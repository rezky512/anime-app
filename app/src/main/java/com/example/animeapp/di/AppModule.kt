package com.example.animeapp.di

import com.example.animeapp.data.remote.api.JikanApiService
import com.example.animeapp.data.repository.AnimeRepositoryImpl
import com.example.animeapp.domain.repository.AnimeRepository
import com.example.animeapp.domain.usecase.GetAnimeDetailUseCase
import com.example.animeapp.domain.usecase.SearchAnimeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()

    @Provides
    @Singleton
    fun provideJikanApi(retrofit: Retrofit): JikanApiService =
        retrofit.create(JikanApiService::class.java)

    @Provides
    @Singleton
    fun provideAnimeRepository(api: JikanApiService): AnimeRepository =
        AnimeRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideSearchAnimeUseCase(repo: AnimeRepository): SearchAnimeUseCase =
        SearchAnimeUseCase(repo)

    @Provides
    @Singleton
    fun provideGetAnimeDetailUseCase(repo: AnimeRepository): GetAnimeDetailUseCase =
        GetAnimeDetailUseCase(repo)
}