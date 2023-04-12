package com.example.platzipodcasts.features.home

import com.example.platzipodcasts.domain.models.PodcastShow

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class ShowPodcastHome(
        val podcastShowCarousel: List<PodcastShow>,
        val podcastShowGrid: List<PodcastShow>
    ) : HomeUiState

    object Error : HomeUiState
}
