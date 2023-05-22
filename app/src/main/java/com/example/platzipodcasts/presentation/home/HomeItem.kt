package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HomeItem(
    image: String,
    text: String?,
    modifier: Modifier = Modifier,
    modifierCard: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Card(
            modifier = modifierCard,
            shape = RoundedCornerShape(10.dp),
            content = {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        )
        if (text != null)
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 4.dp, top = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
    }
}

@Preview
@Composable
fun HomeItemForShowsCarouselPreview() {
    HomeItem(
        image = "",
        text = null,
        modifier = Modifier
            .size(width = 280.dp, height = 180.dp)
            .clickable { }
    )
}

@Preview
@Composable
fun HomeItemForEpisodesCarouselPreview() {
    HomeItem(
        image = "",
        text = "This is an episode",
        modifierCard = Modifier.size(width = 100.dp, height = 100.dp),
        modifier = Modifier
            .width(100.dp)
            .clickable { }
    )
}

@Preview
@Composable
fun HomeItemForShowsGridPreview() {
    HomeItem(
        image = "",
        text = null,
        modifierCard = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { }
    )
}