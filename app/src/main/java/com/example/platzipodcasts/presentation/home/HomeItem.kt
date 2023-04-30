package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
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