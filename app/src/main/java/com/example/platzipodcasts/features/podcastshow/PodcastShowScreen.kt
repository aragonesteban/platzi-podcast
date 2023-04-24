package com.example.platzipodcasts.features.podcastshow

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PodcastShowScreen(
    podcastShowId: Int,
    navController: NavController,
    viewModel: PodcastShowViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        when (val state = viewModel.uiState.collectAsState().value) {
            PodcastShowUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is PodcastShowUiState.ShowContentPodcastShow -> {
                PodcastShowScreenContent(state.showDetail, state.episodes) {
                    navController.popBackStack()
                }
            }
            PodcastShowUiState.Error -> {
                Toast.makeText(context, "Hubo un error", Toast.LENGTH_SHORT).show()
            }
        }
        LaunchedEffect(true) {
            viewModel.getEpisodesByShowId(podcastShowId)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPodcastShow(onBack: () -> Unit) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}