package com.example.platzipodcasts.presentation.podcastshow

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail

data class PodcastShowUiState(
    val isLoading: Boolean = false,
    val showDetail: ShowDetail? = null,
    val episodes:  List<Episode> = listOf(),
    val isError: Boolean = false
)
