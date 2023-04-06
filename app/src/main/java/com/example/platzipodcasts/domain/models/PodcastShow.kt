package com.example.platzipodcasts.domain.models

data class PodcastShow(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val authorId: Int
)
