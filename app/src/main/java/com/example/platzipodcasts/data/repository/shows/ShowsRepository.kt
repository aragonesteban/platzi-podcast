package com.example.platzipodcasts.data.repository.shows

import com.example.platzipodcasts.domain.models.PodcastShow
import com.example.platzipodcasts.domain.models.ShowDetail
import kotlinx.coroutines.flow.Flow

interface ShowsRepository {
    suspend fun getShows(): Flow<List<PodcastShow>>
    suspend fun getShowById(showId: Int): Flow<ShowDetail>
}