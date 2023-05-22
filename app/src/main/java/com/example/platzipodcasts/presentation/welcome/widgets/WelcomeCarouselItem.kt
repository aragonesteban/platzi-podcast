package com.example.platzipodcasts.presentation.welcome.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.R
import com.example.platzipodcasts.presentation.welcome.screen.CarouselItem
import com.example.platzipodcasts.ui.theme.Grey900

@Composable
fun WelcomeCarouselItem(carouselItem: CarouselItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(400.dp)
    ) {
        Image(
            painter = painterResource(id = carouselItem.image),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        Text(
            text = stringResource(id = carouselItem.title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Grey900,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Text(
            text = stringResource(id = carouselItem.description),
            style = MaterialTheme.typography.bodyLarge,
            color = Grey900,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun WelcomeCarouselItemPreview() {
    MaterialTheme {
        WelcomeCarouselItem(
            CarouselItem(
                R.drawable.image_2,
                R.string.label_carousel_item_title_2,
                R.string.label_carousel_item_description_2
            )
        )
    }
}