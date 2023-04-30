package com.example.platzipodcasts.presentation.podcastshow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.platzipodcasts.domain.models.Episode

@Composable
fun PodcastShowEpisodeItem(episode: Episode, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Card(modifier = Modifier.size(width = 80.dp, height = 80.dp)) {
            AsyncImage(model = episode.imageUrl, contentDescription = null)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(5F),
        ) {
            Text(
                text = episode.title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = episode.duration,
                style = MaterialTheme.typography.bodySmall,
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
        Episode(1, "My Episode My Episode My Episode", "", "14:10")
    )
}