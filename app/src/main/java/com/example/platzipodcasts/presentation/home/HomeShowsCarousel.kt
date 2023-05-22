package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.domain.models.PodcastShow

@Composable
fun HomeShowsCarousel(showsList: List<PodcastShow>, onClickShow: (Int) -> Unit) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        HomeTitleSection(title = "Shows Populares", modifier = Modifier.padding(start = 16.dp))
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(showsList) {
                HomeItem(
                    image = it.imageUrl,
                    modifier = Modifier
                        .size(width = 280.dp, height = 180.dp)
                        .clickable { onClickShow(it.id) }
                )
            }
        }
    }
}