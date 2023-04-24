package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeContent(state: HomeUiState.ShowContentHome, goToShow: (Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HomeShowsCarousel(state.showsCarouselList) { showId -> goToShow(showId) }
        HomeEpisodesCarousel(state.episodesList)
        HomeShowsGrid(state.showsGrid) { showId -> goToShow(showId) }
    }
}