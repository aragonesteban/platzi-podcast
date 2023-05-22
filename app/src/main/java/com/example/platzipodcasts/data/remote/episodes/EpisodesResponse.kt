package com.example.platzipodcasts.data.remote.episodes

import com.squareup.moshi.Json

data class EpisodesResponse(
    val response: EpisodesItemsResponse?,
)

data class EpisodesItemsResponse(
    val items: List<EpisodeItemResponse>? = listOf(),
    @Json(name = "next_url")
    val nextUrl: String?
)

data class EpisodeItemResponse(
    @Json(name = "episode_id")
    val id: Int?,
    val title: String?,
    @Json(name = "image_original_url")
    val imageOriginalUrl: String?,
    val duration: Int?,
    @Json(name = "published_at")
    val publishedAt: String?
)
