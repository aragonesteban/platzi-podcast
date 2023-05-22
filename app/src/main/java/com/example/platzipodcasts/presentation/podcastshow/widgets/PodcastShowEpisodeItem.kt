package com.example.platzipodcasts.presentation.podcastshow.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.presentation.utils.advancedShadow
import com.example.platzipodcasts.ui.theme.Grey900

@Composable
fun PodcastShowEpisodeItem(episode: Episode, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Card(
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
                .advancedShadow(Grey900, alpha = 0.2F, shadowBlurRadius = 10.dp),
            shape = RoundedCornerShape(
                topEnd = 12.dp,
                bottomEnd = 12.dp,
                bottomStart = 12.dp
            ),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(episode.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .weight(5F)
                .padding(vertical = 8.dp),
        ) {
            Text(
                text = episode.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${episode.publishedAt} · ${episode.duration}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Icon(
            imageVector = Icons.Filled.PlayCircleFilled,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier
                .size(30.dp)
                .weight(1F)
        )
    }
}

@Preview
@Composable
fun PodcastShowEpisodeItemPreview() {
    PodcastShowEpisodeItem(
        Episode(1, "My Episode My Episode My Episode", "", "14:10", "16 feb 2016")
    )
}