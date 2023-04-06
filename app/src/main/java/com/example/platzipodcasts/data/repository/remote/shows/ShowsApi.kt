package com.example.platzipodcasts.data.repository.remote.shows

import retrofit2.Response
import retrofit2.http.GET

internal const val USER_ID = "userId"

interface ShowsApi {

    @GET("/v2/users/15392018/shows")
    suspend fun getShows(): Response<ShowResponse>

}