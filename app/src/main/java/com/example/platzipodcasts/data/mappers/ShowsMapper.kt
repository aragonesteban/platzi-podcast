package com.example.platzipodcasts.data.mappers

import com.example.platzipodcasts.data.repository.remote.shows.ShowResponse
import com.example.platzipodcasts.domain.models.PodcastShow
import javax.inject.Inject

class ShowsMapper @Inject constructor() :
    PodcastMapper<ShowResponse, ArrayList<PodcastShow>> {

    override fun map(input: ShowResponse): ArrayList<PodcastShow> {
        return ArrayList(
            input.response?.items?.map {
                PodcastShow(
                    id = getShowId(it.showId),
                    title = it.title.orEmpty(),
                    imageUrl = it.imageOriginalUrl.orEmpty(),
                    authorId = it.authorId ?: 0
                )
            } ?: listOf()
        )
    }

    private fun getShowId(showId: Int?): Int {
        return showId?.takeIf { true } ?: run {
            throw IllegalArgumentException("showId is required for screen")
        }
    }
}
