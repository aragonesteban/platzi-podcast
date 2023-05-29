package com.example.platzipodcasts.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.platzipodcasts.presentation.utils.advancedShadow
import com.example.platzipodcasts.ui.theme.Grey900

@Composable
fun HomeItem(
    image: String,
    modifier: Modifier = Modifier,
    pageOffset: Float
) {
    val imageSize by animateFloatAsState(
        targetValue = if (pageOffset != 0.0F) 0.75F else 1F,
        animationSpec = tween(300),
        label = ""
    )

    Card(
        modifier = modifier
            .height(270.dp)
            .width(300.dp)
            .graphicsLayer {
                scaleX = imageSize
                scaleY = imageSize
            }
            .advancedShadow(Grey900, alpha = 0.2F, shadowBlurRadius = 10.dp),
        shape = RoundedCornerShape(12.dp),
        content = {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        },
    )
}

@Preview
@Composable
fun HomeItemForShowsCarouselPreview() {
    HomeItem(
        image = "",
        modifier = Modifier
            .size(width = 280.dp, height = 180.dp)
            .clickable { },
        pageOffset = 1F
    )
}


@Preview
@Composable
fun HomeItemForShowsGridPreview() {
    HomeItem(
        image = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { },
        pageOffset = 1F
    )
}