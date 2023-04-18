package com.example.platzipodcasts.features.home

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.PodcastShow

sealed interface HomeUiState {

    object Loading : HomeUiState

    data class ShowContentHome(
        val showsCarouselList: List<PodcastShow>,
        val showsGrid: List<PodcastShow>,
        val episodesList: List<Episode>
    ) : HomeUiState

    object Error : HomeUiState

}
