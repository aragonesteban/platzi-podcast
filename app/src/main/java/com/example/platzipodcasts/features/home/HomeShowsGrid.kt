package com.example.platzipodcasts.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.domain.models.PodcastShow

@Composable
fun HomeShowsGrid(showsList: List<PodcastShow>, onClickShow: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .height(280.dp)
    ) {
        HomeTitleSection(title = "Shows", modifier = Modifier.padding(start = 16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(showsList) {
                HomeItem(image = it.imageUrl,
                    text = null,
                    modifierCard = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable { onClickShow(it.id) })
            }
        }
    }
}
