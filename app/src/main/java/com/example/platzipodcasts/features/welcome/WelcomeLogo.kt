package com.example.platzipodcasts.features.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.R

@Composable
fun Logo() {
    val isDarkMode = isSystemInDarkTheme()
    Image(
        painter = painterResource(
            if (isDarkMode) R.drawable.logo_platzi_podcast_dark else R.drawable.logo_platzi_podcast_light
        ),
        contentDescription = null,
        modifier = Modifier.width(148.dp)
    )
}