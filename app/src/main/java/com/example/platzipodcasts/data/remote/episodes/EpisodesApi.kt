package com.example.platzipodcasts.data.remote.episodes

import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.SHOWS
import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.SHOW_ID
import com.example.platzipodcasts.data.remote.utils.SpeakerApiConstants.USERS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val LIMIT = "limit"
private const val LIMIT_EPISODES = 5

interface EpisodesApi {

    @GET("/v2/$USERS/15392018/episodes")
    suspend fun getEpisodes(
        @Query(LIMIT) limit: Int = LIMIT_EPISODES
    ): Response<EpisodesResponse>

    @GET("v2/$SHOWS/{$SHOW_ID}/episodes")
    suspend fun getEpisodesByShowId(
        @Path(SHOW_ID) showId: Int
    ): Response<EpisodesResponse>

}