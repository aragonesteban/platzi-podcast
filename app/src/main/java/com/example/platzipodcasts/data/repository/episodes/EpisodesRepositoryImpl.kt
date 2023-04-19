package com.example.platzipodcasts.data.repository.episodes

import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.remote.episodes.EpisodesApi
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.data.remote.utils.handleNetworkResult
import com.example.platzipodcasts.data.remote.utils.handleRequest
import com.example.platzipodcasts.domain.models.Episode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val episodesApi: EpisodesApi,
    private val mapper: PodcastMapper<EpisodesResponse, ArrayList<Episode>>
) : EpisodesRepository {

    override fun getEpisodes(): Flow<List<Episode>> {
        return flow {
            val result = episodesApi.getEpisodes().handleRequest { data ->
                mapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }
    }

    override fun getEpisodesByShowId(showId: Int): Flow<List<Episode>> {
        return flow {
            val result = episodesApi.getEpisodesByShowId(showId).handleRequest { data ->
                mapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }
    }
}