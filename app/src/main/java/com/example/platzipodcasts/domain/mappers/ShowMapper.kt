package com.example.platzipodcasts.domain.mappers

import com.example.platzipodcasts.data.remote.shows.ShowDetailResponse
import com.example.platzipodcasts.data.utils.getShowId
import com.example.platzipodcasts.domain.models.ShowDetail
import com.example.platzipodcasts.domain.utils.PodcastMapper
import javax.inject.Inject

class ShowMapper @Inject constructor() : PodcastMapper<ShowDetailResponse, ShowDetail> {

    override fun map(input: ShowDetailResponse): ShowDetail {
        with(input.response.show) {
            return ShowDetail(
                id = showId.getShowId(),
                title = title.orEmpty(),
                description = description.orEmpty(),
                imageUrl = imageOriginalUrl.orEmpty()
            )
        }
    }

}