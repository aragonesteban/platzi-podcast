package com.example.platzipodcasts.domain.mappers

import com.example.platzipodcasts.data.remote.episodes.EpisodeItemResponse
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.Episodes
import com.example.platzipodcasts.domain.utils.PodcastMapper
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class EpisodesMapper @Inject constructor() : PodcastMapper<EpisodesResponse, Episodes> {

    override fun map(input: EpisodesResponse): Episodes {
        return input.response?.takeIf { true }?.let { response ->
            Episodes(
                nextUrl = response.nextUrl.orEmpty(),
                episodesList = response.items?.map(::mapEpisodesList).orEmpty()
            )
        } ?: run { throw IllegalArgumentException("response is required to get episodes") }
    }

    private fun mapEpisodesList(episode: EpisodeItemResponse): Episode {
        return Episode(
            id = getEpisodeId(episode.id),
            title = episode.title.orEmpty(),
            imageUrl = episode.imageOriginalUrl.orEmpty(),
            duration = formatMilliseconds(milliseconds = episode.duration?.toLong() ?: 0),
            publishedAt = mapPublishedAt(episode.publishedAt)
        )
    }

    private fun getEpisodeId(episodeId: Int?): Int {
        return episodeId?.takeIf { true } ?: run {
            throw IllegalArgumentException("showId is required for screen")
        }
    }

    private fun formatMilliseconds(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return "%02d:%02d".format(minutes, seconds)
    }

    private fun mapPublishedAt(publishedAt: String?): String {
        return publishedAt?.takeIf { true }?.run {
            val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val date = LocalDate.parse(this, inputFormatter)
            val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
            return@run date.format(outputFormatter)
        } ?: throw IllegalArgumentException("publishedAt is required for screen")
    }
}