package com.example.platzipodcasts.features.podcastshow

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PodcastShowScreen(podcastShowId: Int) {
    Text(text = "Hola $podcastShowId")
}