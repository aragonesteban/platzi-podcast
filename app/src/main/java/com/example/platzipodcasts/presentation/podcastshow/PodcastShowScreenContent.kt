package com.example.platzipodcasts.presentation.podcastshow

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.platzipodcasts.navigation.NavGraphScreens

@Composable
fun PodcastShowScreenContent(
    uiState: PodcastShowUiState,
    navController: NavController,
    onLoadMoreEpisodes: () -> Unit
) {
    var episodeList by rememberSaveable { mutableStateOf(uiState.episodes) }
    LaunchedEffect(uiState.episodes) { episodeList = uiState.episodes }
    val lazyListState = rememberLazyListState()
    val layoutInfo = remember { derivedStateOf { lazyListState.layoutInfo } }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (uiState.isError) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }

        LazyColumn(state = lazyListState) {
            item { uiState.showDetail?.let { PodcastShowDetail(it) } }
            itemsIndexed(episodeList) { index, episode ->
                key(episode.id) {
                    PodcastShowEpisodeItem(episode, modifier = Modifier
                        .clickable {
                            navController.navigate(NavGraphScreens.EpisodeScreen(episode.id).routeWithId)
                        }
                        .padding(16.dp))
                }
                if (index != episodeList.lastIndex) Divider()
            }
        }

        if (layoutInfo.value.visibleItemsInfo.lastOrNull()?.index == layoutInfo.value.totalItemsCount - 1) {
            onLoadMoreEpisodes()
        }
    }
}