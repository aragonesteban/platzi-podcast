package com.example.platzipodcasts.presentation.podcastshow

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.ShowDetail
import com.example.platzipodcasts.navigation.NavGraphScreens

@Composable
fun PodcastShowScreenContent(
    showDetail: ShowDetail,
    episodesList: List<Episode>,
    navController: NavController,
    onLoadMoreEpisodes: () -> Unit
) {
    val episodes = remember { mutableStateListOf<Episode>() }
    val lazyListState = rememberLazyListState()
    val layoutInfo by remember { derivedStateOf { lazyListState.layoutInfo } }
    LaunchedEffect(true) { episodes.addAll(episodesList) }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(state = lazyListState) {
            item { PodcastShowDetail(showDetail) }
            itemsIndexed(episodes) { index, episode ->
                key(episode.id) {
                    PodcastShowEpisodeItem(episode, modifier = Modifier
                        .clickable {
                            navController.navigate(NavGraphScreens.EpisodeScreen(episode.id).routeWithId)
                        }
                        .padding(16.dp))
                }
                if (index != episodes.lastIndex) {
                    Divider()
                }
            }
        }
        if (layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1) {
            LaunchedEffect(Unit) { onLoadMoreEpisodes() }
        }
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
    }
}