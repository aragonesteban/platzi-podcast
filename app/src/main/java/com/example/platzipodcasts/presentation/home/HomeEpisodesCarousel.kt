package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.domain.models.Episode

@Composable
fun HomeEpisodesCarousel(episodesList: List<Episode>) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        HomeTitleSection(title = "Episodios Populares", modifier = Modifier.padding(start = 16.dp))
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(episodesList) {
                HomeItem(
                    image = it.imageUrl,
                    text = it.title,
                    modifierCard = Modifier.size(width = 100.dp, height = 100.dp),
                    modifier = Modifier
                        .width(100.dp)
                        .clickable { }
                )
            }
        }
    }
}