package com.example.platzipodcasts.presentation.podcastshow

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail

sealed interface PodcastShowUiState {
    object Loading : PodcastShowUiState

    data class ShowContentPodcastShow(
        val showDetail: ShowDetail,
        val episodes: List<Episode>
    ) : PodcastShowUiState

    object Error : PodcastShowUiState
}