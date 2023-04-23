package com.example.platzipodcasts.data.remote.shows

import com.squareup.moshi.Json

data class ShowDetailResponse(
    val response: ShowDetailItemResponse
)

data class ShowDetailItemResponse(
    val show: ShowDetailDataResponse
)

data class ShowDetailDataResponse(
    @Json(name = "show_id")
    val showId: Int?,
    val description: String?,
    @Json(name = "image_original_url")
    val imageOriginalUrl: String?,
    val title: String?
)