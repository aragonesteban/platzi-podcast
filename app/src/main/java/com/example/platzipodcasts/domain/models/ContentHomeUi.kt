package com.example.platzipodcasts.domain.models

import com.example.platzipodcasts.data.remote.utils.NetworkResult

data class ContentHomeUi(
    val showsList: List<PodcastShow> = listOf(),
    val episodesLists: List<Episode> = listOf(),
    val error: NetworkResult.Error? = null
)