package com.example.platzipodcasts.features.podcastshow

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastShowScreenContent(
    showDetail: ShowDetail,
    episodesList: List<Episode>,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = { TopBarPodcastShow { onBack() } }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item { PodcastShowDetail(showDetail) }
            itemsIndexed(episodesList) { index, episode ->
                PodcastShowEpisodeItem(episode)
                if (index != episodesList.lastIndex) {
                    Divider()
                }
            }
        }
    }
}