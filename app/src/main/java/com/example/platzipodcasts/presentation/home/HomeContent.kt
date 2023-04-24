package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.platzipodcasts.navigation.NavGraphScreens

@Composable
fun HomeContent(
    content: HomeUiState.ShowContentHome,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HomeShowsCarousel(content.showsCarouselList) { showId ->
            navController.navigate(NavGraphScreens.PodcastShowScreen(showId).routeWithId)
        }
        HomeEpisodesList(content.episodesList) { episodeId ->
            navController.navigate(NavGraphScreens.EpisodeScreen(episodeId).routeWithId)
        }
        HomeShowsGrid(content.showsGrid) { showId ->
            navController.navigate(NavGraphScreens.PodcastShowScreen(showId).routeWithId)
        }
    }
}