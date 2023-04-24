package com.example.platzipodcasts.presentation.episode

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EpisodeScreen(episodeId: Int) {
    Text(text = episodeId.toString())
}