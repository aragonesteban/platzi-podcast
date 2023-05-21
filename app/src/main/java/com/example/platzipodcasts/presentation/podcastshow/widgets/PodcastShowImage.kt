package com.example.platzipodcasts.presentation.podcastshow.widgets

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.platzipodcasts.presentation.utils.advancedShadow

@Composable
fun PodcastShowImage(imageUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .allowHardware(false)
            .size(Size.ORIGINAL)
            .build()
    )
    if (painter.state is AsyncImagePainter.State.Success) {
        val bitmap =
            (painter.state as? AsyncImagePainter.State.Success)?.result?.drawable?.toBitmap()
        val color = getColorDominantFromImage(bitmap)

        Box(
            modifier = Modifier
                .padding(top = 64.dp)
                .size(200.dp)
                .advancedShadow(
                    color = Color(color),
                    shadowBlurRadius = 100.dp,
                    offsetY = (-30).dp
                )
                .clip(RoundedCornerShape(8.dp))
        ) {
            AsyncImage(
                model = imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
    }
}

fun getColorDominantFromImage(bitmap: Bitmap?): Int =
    bitmap.takeIf { true }
        ?.let { Palette.from(it).generate().dominantSwatch?.rgb ?: 0 }
        ?: throw IllegalArgumentException("image bitmap is required")
