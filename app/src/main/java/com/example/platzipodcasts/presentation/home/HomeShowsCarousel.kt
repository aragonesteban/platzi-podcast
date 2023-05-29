package com.example.platzipodcasts.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.domain.models.PodcastShow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeShowsCarousel(showsList: List<PodcastShow>, onClickShow: (Int) -> Unit) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = showsList.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 60.dp),
        modifier = Modifier.padding(top = 32.dp)
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        HomeItem(
            image = showsList[page].imageUrl,
            pageOffset = pageOffset,
            modifier = Modifier.clickable { onClickShow(showsList[page].id) }
        )
    }
}