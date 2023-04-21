package com.example.platzipodcasts.data.remote.shows

import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.SHOWS
import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.SHOW_ID
import retrofit2.Response
import retrofit2.http.GET
import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.USERS
import retrofit2.http.Path

interface ShowsApi {

    @GET("/v2/$USERS/15392018/shows")
    suspend fun getShows(): Response<PodcastShowsResponse>

    @GET("/v2/$SHOWS/{$SHOW_ID}")
    suspend fun getShowById(
        @Path(SHOW_ID) showId: Int
    ): Response<ShowDetailResponse>

}