package com.example.platzipodcasts.data.repository.episodes

import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.Episodes
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getEpisodes(): Flow<List<Episode>>
    fun getEpisodesByShowId(showId: Int): Flow<Episodes>
    fun getEpisodesByUrl(url: String): Flow<Episodes>

}