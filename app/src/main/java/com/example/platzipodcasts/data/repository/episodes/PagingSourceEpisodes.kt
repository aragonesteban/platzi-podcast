package com.example.platzipodcasts.data.repository.episodes

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.platzipodcasts.domain.models.Episode
import kotlinx.coroutines.flow.firstOrNull

class PagingSourceEpisodes(
    private val episodesRepository: EpisodesRepository,
    private val showId: Int
) : PagingSource<Int, Episode>() {

    private var currentUrl: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        val id = params.key ?: showId

        val result = when {
            currentUrl?.isNotEmpty() == true -> episodesRepository.getEpisodesByUrl(currentUrl.orEmpty())
            id != 0 -> episodesRepository.getEpisodesByShowId(id)
            else -> null
        }

        val episodes = result?.firstOrNull()

        currentUrl = episodes?.nextUrl

        return LoadResult.Page(
            data = episodes?.episodesList.orEmpty(),
            prevKey = null,
            nextKey = episodes?.nextUrl?.hashCode()
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Episode>): Int {
        currentUrl = null
        return showId
    }
}