package com.example.platzipodcasts.features.podcastshow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.platzipodcasts.domain.models.Episode

@Composable
fun PodcastShowEpisodesList(episodes: List<Episode>) {
    Column {
        episodes.forEach {
            PodcastShowEpisodeItem(it)
        }
    }
}