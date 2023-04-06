package com.example.platzipodcasts.features.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.R

@Composable
fun WelcomeScreen(navigateToHome: () -> Unit) {
    var currentPositionCarousel by rememberSaveable { mutableStateOf(0) }

    val imagesList by rememberSaveable {
        mutableStateOf(
            listOf(
                CarouselItem(R.drawable.image_2, R.string.label_carousel_item_1),
                CarouselItem(R.drawable.image_3, R.string.label_carousel_item_2),
                CarouselItem(R.drawable.image_4, R.string.label_carousel_item_3)
            )
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp)
    ) {
        Logo()
        Carousel(
            imagesList = imagesList,
            onSetCurrentPage = { currentPage -> currentPositionCarousel = currentPage }
        )

        Column {
            WelcomeDots(imagesList.size, currentPositionCarousel)
            Button(
                onClick = { navigateToHome.invoke() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 36.dp)
            ) {
                Text(text = stringResource(id = R.string.btn_continue_welcome_screen))
            }
        }
    }
}

data class CarouselItem(
    val image: Int,
    val text: Int,
)
