package com.example.platzipodcasts.data.repository.episodes

import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.remote.episodes.EpisodesApi
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.data.remote.utils.NetworkResult
import com.example.platzipodcasts.data.remote.utils.handleRequest
import com.example.platzipodcasts.domain.models.Episode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val episodesApi: EpisodesApi,
    private val mapper: PodcastMapper<EpisodesResponse, ArrayList<Episode>>
) : EpisodesRepository {
    override fun getEpisodes(): Flow<NetworkResult<List<Episode>>> {
        return flow {
            emit(
                episodesApi.getEpisodes().handleRequest() { data -> mapper.map(data) }
            )
        }
    }
}