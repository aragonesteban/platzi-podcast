package com.example.platzipodcasts.presentation.welcome.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.platzipodcasts.presentation.welcome.screen.CarouselItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    imagesList: List<CarouselItem>,
    currentPositionCarousel: Int,
    onSetCurrentPage: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = imagesList.size,
        state = pagerState,
        modifier = modifier
    ) { page ->
        WelcomeCarouselItem(carouselItem = imagesList[page])
    }

    LaunchedEffect(currentPositionCarousel) {
        pagerState.animateScrollToPage(currentPositionCarousel)
    }

    LaunchedEffect(pagerState.currentPage) {
        onSetCurrentPage.invoke(pagerState.currentPage)
    }

}
