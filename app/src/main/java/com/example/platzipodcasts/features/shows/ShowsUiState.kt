package com.example.platzipodcasts.features.shows

import com.example.platzipodcasts.domain.models.PodcastShow

sealed interface ShowsUiState {
    object Loading : ShowsUiState
    data class ShowPodcastShows(val data: List<PodcastShow>) : ShowsUiState
    object Error : ShowsUiState
}
