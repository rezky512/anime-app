package com.example.animeapp.presentation.anime_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.domain.model.Anime
import com.example.animeapp.domain.usecase.GetAnimeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val getAnimeDetailUseCase: GetAnimeDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _anime = MutableStateFlow<Anime?>(null)
    val anime: StateFlow<Anime?> = _anime

    init {
        val malIdString = savedStateHandle.get<String>("malId")
        val malId = malIdString?.toIntOrNull()
        if (malId != null) {
            viewModelScope.launch {
                _anime.value = getAnimeDetailUseCase(malId)
            }
        }
    }
}