package com.example.platzipodcasts.data.mappers

import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.domain.models.Episode
import javax.inject.Inject

class EpisodesMapper @Inject constructor() : PodcastMapper<EpisodesResponse, ArrayList<Episode>> {

    override fun map(input: EpisodesResponse): ArrayList<Episode> {
        return ArrayList(
            input.response?.items?.map { item ->
                Episode(
                    id = getEpisodeId(item.id),
                    title = item.title.orEmpty(),
                    imageUrl = item.imageOriginalUrl.orEmpty()
                )
            }.orEmpty()
        )
    }

    private fun getEpisodeId(episodeId: Int?): Int {
        return episodeId?.takeIf { true } ?: run {
            throw IllegalArgumentException("showId is required for screen")
        }
    }

}