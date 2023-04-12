package com.example.platzipodcasts.data.repository.remote.episodes

import com.example.platzipodcasts.data.repository.remote.SpeakerApiConstants.USERS
import com.example.platzipodcasts.data.repository.remote.shows.ShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val LIMIT = "limit"

interface EpisodesApi {

    @GET("/v2/${USERS}/15392018/episodes")
    suspend fun getEpisodes(
        @Query(LIMIT) limit: Int = 5
    ): Response<ShowResponse>

}