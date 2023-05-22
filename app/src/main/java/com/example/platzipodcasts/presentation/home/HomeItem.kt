package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.platzipodcasts.presentation.utils.advancedShadow
import com.example.platzipodcasts.ui.theme.Grey900

@Composable
fun HomeItem(
    image: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.advancedShadow(
            color = Grey900,
            alpha = 0.2F,
            shadowBlurRadius = 10.dp
        ),
        shape = RoundedCornerShape(
            topEnd = 12.dp,
            bottomEnd = 12.dp,
            bottomStart = 12.dp
        ),
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
            .clickable { }
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
            .clickable { }
    )
}