package com.example.platzipodcasts.presentation.podcastshow

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail

sealed interface PodcastShowUiState {
    object LoadingShowDetail : PodcastShowUiState

    object LoadingEpisodes : PodcastShowUiState

    data class ShowContentShowDetail(val data: ShowDetail) : PodcastShowUiState

    data class ShowEpisodes(val data: List<Episode>) : PodcastShowUiState

    object Error : PodcastShowUiState
}