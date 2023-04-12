package com.example.platzipodcasts.features.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navigateToShow: (Int) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            HomeHeader()
            val state = viewModel.uiState.collectAsState().value
            val context = LocalContext.current
            when (state) {
                HomeUiState.Loading -> Loading()
                is HomeUiState.ShowPodcastHome -> {
                    HomeShowsCarousel(state.podcastShowCarousel) { showId ->
                        navigateToShow(showId)
                    }
                }
                HomeUiState.Error -> {
                    Toast.makeText(context, "Hubo un error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
        Text(text = "Loading...")
    }
}
