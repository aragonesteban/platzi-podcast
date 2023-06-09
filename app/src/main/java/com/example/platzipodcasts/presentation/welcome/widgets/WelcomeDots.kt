package com.example.platzipodcasts.presentation.welcome.widgets

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.ui.theme.Grey300
import com.example.platzipodcasts.ui.theme.Grey900

@Composable
fun WelcomeDots(imagesListSize: Int, currentPositionCarousel: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 28.dp)
    ) {
        repeat(imagesListSize) { index ->
            val targetSize = remember { 30.dp }

            val sizeAsState = animateFloatAsState(
                targetValue = if (index == currentPositionCarousel) targetSize.value else 10.dp.value,
                animationSpec = TweenSpec(durationMillis = 100, easing = LinearEasing),
                label = ""
            )
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(
                        if (index == currentPositionCarousel) sizeAsState.value.dp else 10.dp,
                        10.dp
                    )
                    .background(
                        color = getColorDotDarkLightMode(index, currentPositionCarousel),
                        shape = CircleShape
                    )
            )
        }
    }
}

fun getColorDotDarkLightMode(index: Int, currentPositionCarousel: Int): Color {
    return if (index == currentPositionCarousel)
        Grey900
    else
        Grey300
}
