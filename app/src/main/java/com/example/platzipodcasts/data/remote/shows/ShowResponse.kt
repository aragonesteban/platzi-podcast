package com.example.platzipodcasts.data.remote.shows

import com.squareup.moshi.Json

data class ShowResponse(
    val response: ShowItemsResponse?
)

data class ShowItemsResponse(
    val items: List<ShowItemResponse>? = listOf()
)

data class ShowItemResponse(
    @Json(name = "show_id")
    val showId: Int?,
    val title: String?,
    @Json(name = "image_original_url")
    val imageOriginalUrl: String?,
    @Json(name = "author_id")
    val authorId: Int?
)
