package com.example.platzipodcasts.data.repository.episodes

import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.remote.episodes.EpisodesApi
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.data.remote.utils.handleNetworkResult
import com.example.platzipodcasts.data.remote.utils.handleRequest
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.Episodes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val episodesApi: EpisodesApi,
    private val mapper: PodcastMapper<EpisodesResponse, Episodes>
) : EpisodesRepository {

    override fun getEpisodes(): Flow<List<Episode>> {
        return flow {
            val result = episodesApi.getEpisodes().handleRequest { data ->
                mapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data.episodesList) }
        }.flowOn(Dispatchers.IO)
    }

    override fun getEpisodesByShowId(showId: Int): Flow<Episodes> {
        return flow {
            val result = episodesApi.getEpisodesByShowId(showId).handleRequest { data ->
                mapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }.flowOn(Dispatchers.IO)
    }

    override fun getEpisodesByUrl(url: String): Flow<Episodes> {
        return flow {
            val result = episodesApi.getEpisodesByUrl(url).handleRequest { data ->
                mapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }.flowOn(Dispatchers.IO)
    }

}