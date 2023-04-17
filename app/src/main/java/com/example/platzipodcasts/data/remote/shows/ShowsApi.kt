package com.example.platzipodcasts.data.remote.shows

import retrofit2.Response
import retrofit2.http.GET
import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.USERS

interface ShowsApi {

    @GET("/v2/$USERS/15392018/shows")
    suspend fun getShows(): Response<ShowResponse>

}