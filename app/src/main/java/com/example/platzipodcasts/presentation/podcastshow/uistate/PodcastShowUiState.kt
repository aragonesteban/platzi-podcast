package com.example.platzipodcasts.presentation.podcastshow.uistate

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail

data class PodcastShowUiState(
    val isLoading: Boolean = false,
    val showDetail: ShowDetail? = null,
    val isError: Boolean = false
)
