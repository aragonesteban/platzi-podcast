package com.example.platzipodcasts.features.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navigateToShow: (Int) -> Unit) {
    Box {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val state = viewModel.uiState.collectAsState().value
            val context = LocalContext.current
            when (state) {
                HomeUiState.Loading ->  CircularProgressIndicator()
                is HomeUiState.ShowContentHome -> {
                    HomeHeader()
                    HomeShowsCarousel(state.showsCarouselList) { showId -> navigateToShow(showId) }
                    HomeEpisodesCarousel(state.episodesList)
                    HomeShowsGrid(state.showsGrid) { showId -> navigateToShow(showId) }
                }
                HomeUiState.Error -> {
                    Toast.makeText(context, "Hubo un error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
