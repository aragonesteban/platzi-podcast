package com.example.platzipodcasts.features.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.ui.theme.md_theme_dark_secondary
import com.example.platzipodcasts.ui.theme.md_theme_light_onSurfaceVariant
import kotlinx.coroutines.delay

private const val INTERVAL_AUTO_SWIPE_CAROUSEL = 4000L

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(imagesList: List<CarouselItem>, onSetCurrentPage: (Int) -> Unit) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = imagesList.size,
        state = pagerState,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imagesList[it].image),
                contentDescription = null,
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 24.dp)
            )
            Text(
                text = stringResource(id = imagesList[it].text),
                style = MaterialTheme.typography.bodyLarge,
                color = if (isSystemInDarkTheme()) md_theme_dark_secondary else md_theme_light_onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        onSetCurrentPage.invoke(pagerState.currentPage)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(INTERVAL_AUTO_SWIPE_CAROUSEL)
            if (pagerState.isScrollInProgress.not()) {
                pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % imagesList.size)
            }
        }
    }
}
