package com.example.platzipodcasts.data.remote.shows

import com.squareup.moshi.Json

data class PodcastShowsResponse(
    val response: PodcastShowsItemsResponse?
)

data class PodcastShowsItemsResponse(
    val items: List<PodcastShowItemResponse>? = listOf()
)

data class PodcastShowItemResponse(
    @Json(name = "show_id")
    val showId: Int?,
    val title: String?,
    @Json(name = "image_original_url")
    val imageOriginalUrl: String?,
    @Json(name = "author_id")
    val authorId: Int?
)
