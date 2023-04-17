package com.example.platzipodcasts.data.repository.episodes

import com.example.platzipodcasts.data.remote.utils.NetworkResult
import com.example.platzipodcasts.domain.models.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getEpisodes(): Flow<NetworkResult<List<Episode>>>
}