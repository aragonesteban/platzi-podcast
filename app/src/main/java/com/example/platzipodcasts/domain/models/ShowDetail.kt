package com.example.platzipodcasts.domain.models

data class ShowDetail(
    val id: Int,
    val description: String,
    val imageUrl: String,
    val title: String,
    val numberEpisodes: Int = 0
)