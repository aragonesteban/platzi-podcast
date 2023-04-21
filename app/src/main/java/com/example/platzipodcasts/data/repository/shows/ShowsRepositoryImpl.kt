package com.example.platzipodcasts.data.repository.shows

import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.remote.shows.PodcastShowsResponse
import com.example.platzipodcasts.data.remote.shows.ShowDetailResponse
import com.example.platzipodcasts.data.remote.shows.ShowsApi
import com.example.platzipodcasts.data.remote.utils.handleNetworkResult
import com.example.platzipodcasts.data.remote.utils.handleRequest
import com.example.platzipodcasts.domain.models.PodcastShow
import com.example.platzipodcasts.domain.models.ShowDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val showsApi: ShowsApi,
    private val podcastShowsMapper: PodcastMapper<PodcastShowsResponse, ArrayList<PodcastShow>>,
    private val showMapper: PodcastMapper<ShowDetailResponse, ShowDetail>
) : ShowsRepository {

    override suspend fun getShows(): Flow<List<PodcastShow>> {
        return flow {
            val result = showsApi.getShows().handleRequest { data ->
                podcastShowsMapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }
    }

    override suspend fun getShowById(showId: Int): Flow<ShowDetail> {
        return flow {
            val result = showsApi.getShowById(showId).handleRequest { data ->
                showMapper.map(data)
            }
            result.handleNetworkResult { data -> emit(data) }
        }
    }
}