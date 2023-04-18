package com.example.platzipodcasts.features.home

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
                val colorsGradient = listOf(
                    Color.Transparent,
                    Color(0xA3000000)
                )
                Box {
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.7F)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Brush.verticalGradient(colors = colorsGradient))
                    )
                }
            }
        )
        if (text != null)
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 4.dp, top = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
    }
}

@Preview
@Composable
fun HomeShowsCarouselItemPreview() {
    HomeItem(
        image = "",
        text = "",
        modifier = Modifier
            .size(width = 280.dp, height = 180.dp)
            .clickable { }
    )
}