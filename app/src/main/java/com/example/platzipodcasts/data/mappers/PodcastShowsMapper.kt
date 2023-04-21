package com.example.platzipodcasts.data.mappers

import com.example.platzipodcasts.data.remote.shows.PodcastShowsResponse
import com.example.platzipodcasts.data.utils.getShowId
import com.example.platzipodcasts.domain.models.PodcastShow
import javax.inject.Inject

class PodcastShowsMapper @Inject constructor() :
    PodcastMapper<PodcastShowsResponse, ArrayList<PodcastShow>> {

    override fun map(input: PodcastShowsResponse): ArrayList<PodcastShow> {
        return ArrayList(
            input.response?.items?.map {
                PodcastShow(
                    id = it.showId.getShowId(),
                    title = it.title.orEmpty(),
                    imageUrl = it.imageOriginalUrl.orEmpty()
                )
            }.orEmpty()
        )
    }

}
