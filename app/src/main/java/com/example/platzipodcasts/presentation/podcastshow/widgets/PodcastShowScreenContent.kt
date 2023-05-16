package com.example.platzipodcasts.presentation.podcastshow.widgets

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.navigation.NavGraphScreens
import com.example.platzipodcasts.presentation.podcastshow.uistate.PodcastShowUiState

@Composable
fun PodcastShowScreenContent(
    uiState: PodcastShowUiState,
    episodesList: LazyPagingItems<Episode>,
    navController: NavController,
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (uiState.isError) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }

        LazyColumn(state = rememberLazyListState()) {
            item { uiState.showDetail?.let { PodcastShowDetail(it) } }
            items(episodesList.itemCount) { position ->
                episodesList[position]?.let {episode ->
                    key(episode.id) {
                        PodcastShowEpisodeItem(episode, modifier = Modifier
                            .clickable {
                                navController.navigate(NavGraphScreens.EpisodeScreen(episode.id).routeWithId)
                            }
                            .padding(16.dp))
                    }
                }
                if (position != episodesList.itemSnapshotList.lastIndex)
                    Divider(color = MaterialTheme.colorScheme.surface)
            }
        }
    }
}