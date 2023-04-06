package com.example.platzipodcasts.data.repository.shows

import com.example.platzipodcasts.data.repository.remote.NetworkResult
import com.example.platzipodcasts.domain.models.PodcastShow
import kotlinx.coroutines.flow.Flow

interface ShowsRepository {
    suspend fun getShows(): Flow<NetworkResult<List<PodcastShow>>>
}