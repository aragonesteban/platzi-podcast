package com.example.platzipodcasts.domain.models

data class Episode(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val duration: String
)