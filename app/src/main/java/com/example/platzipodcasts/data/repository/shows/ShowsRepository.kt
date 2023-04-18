package com.example.platzipodcasts.data.repository.shows

import com.example.platzipodcasts.domain.models.PodcastShow
import kotlinx.coroutines.flow.Flow

interface ShowsRepository {
    suspend fun getShows(): Flow<List<PodcastShow>>
}