package com.example.platzipodcasts.presentation.podcastshow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail
import com.example.platzipodcasts.navigation.NavGraphScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastShowScreenContent(
    showDetail: ShowDetail,
    episodesList: List<Episode>,
    navController: NavController
) {
    Scaffold(
        topBar = { TopBarPodcastShow { navController.popBackStack() } }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item { PodcastShowDetail(showDetail) }
            itemsIndexed(episodesList) { index, episode ->
                PodcastShowEpisodeItem(
                    episode,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavGraphScreens.EpisodeScreen(episode.id).routeWithId)
                        }
                        .padding(16.dp)
                )
                if (index != episodesList.lastIndex) {
                    Divider()
                }
            }
        }
    }
}