package com.example.platzipodcasts.presentation.podcastshow.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.platzipodcasts.presentation.podcastshow.viewmodels.PodcastShowViewModel
import com.example.platzipodcasts.presentation.podcastshow.widgets.PodcastShowScreenContent

@Composable
fun PodcastShowScreen(
    podcastShowId: Int,
    navController: NavController,
    viewModel: PodcastShowViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        PodcastShowScreenContent(
            uiState = viewModel.uiState.collectAsState().value,
            viewModel.episodesList.collectAsLazyPagingItems(),
            navController = navController,
        )
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
    }
    LaunchedEffect(true) {
        viewModel.getShowDetailById(podcastShowId)
    }
}