package com.example.platzipodcasts.presentation.welcome.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.R
import com.example.platzipodcasts.presentation.welcome.widgets.Carousel
import com.example.platzipodcasts.presentation.welcome.widgets.WelcomeButtons
import com.example.platzipodcasts.presentation.welcome.widgets.WelcomeDots

@Composable
fun WelcomeScreen(navigateToHome: () -> Unit) {
    var currentPositionCarousel by rememberSaveable { mutableStateOf(0) }

    val imagesList by rememberSaveable {
        mutableStateOf(
            listOf(
                CarouselItem(
                    R.drawable.image_2,
                    R.string.label_carousel_item_title_1,
                    R.string.label_carousel_item_description_1
                ),
                CarouselItem(
                    R.drawable.image_3,
                    R.string.label_carousel_item_title_2,
                    R.string.label_carousel_item_description_2
                ),
                CarouselItem(
                    R.drawable.image_4,
                    R.string.label_carousel_item_title_3,
                    R.string.label_carousel_item_description_3
                )
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, bottom = 20.dp)
    ) {
        Carousel(
            imagesList = imagesList,
            currentPositionCarousel = currentPositionCarousel,
            onSetCurrentPage = { currentPage -> currentPositionCarousel = currentPage },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
        )

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            WelcomeDots(imagesList.size, currentPositionCarousel)
            WelcomeButtons(
                positionCarousel = currentPositionCarousel,
                navigateToHome = navigateToHome,
                onChangePage = {
                    currentPositionCarousel = (currentPositionCarousel + 1) % imagesList.size
                }
            )
        }
    }
}

data class CarouselItem(
    val image: Int,
    val title: Int,
    val description: Int
)
