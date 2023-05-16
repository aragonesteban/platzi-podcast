package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.presentation.podcastshow.widgets.PodcastShowEpisodeItem

@Composable
fun HomeEpisodesList(
    episodesList: List<Episode>,
    navigateToEpisode: (Int) -> Unit
) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        HomeTitleSection(title = "Episodios Populares", modifier = Modifier.padding(start = 16.dp))
        episodesList.forEach { episode ->
            PodcastShowEpisodeItem(
                episode = episode,
                modifier = Modifier
                    .clickable { navigateToEpisode.invoke(episode.id) }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}