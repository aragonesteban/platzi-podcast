package com.example.platzipodcasts.domain.models

data class Episodes(
    var nextUrl: String,
    var episodesList: List<Episode>
)

data class Episode(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val duration: String,
    val publishedAt: String
)