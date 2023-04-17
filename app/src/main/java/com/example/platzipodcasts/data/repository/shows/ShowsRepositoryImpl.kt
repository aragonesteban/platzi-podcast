package com.example.platzipodcasts.data.repository.shows

import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.remote.utils.NetworkResult
import com.example.platzipodcasts.data.remote.utils.handleRequest
import com.example.platzipodcasts.data.remote.shows.ShowResponse
import com.example.platzipodcasts.data.remote.shows.ShowsApi
import com.example.platzipodcasts.domain.models.PodcastShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val showsApi: ShowsApi,
    private val mapper: PodcastMapper<ShowResponse, ArrayList<PodcastShow>>
) : ShowsRepository {

    override suspend fun getShows(): Flow<NetworkResult<List<PodcastShow>>> {
        return flow {
            emit(
                showsApi.getShows().handleRequest() { data -> mapper.map(data) }
            )
        }
    }
}