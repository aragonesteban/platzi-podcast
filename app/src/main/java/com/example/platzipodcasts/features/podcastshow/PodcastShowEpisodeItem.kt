package com.example.platzipodcasts.features.podcastshow

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.platzipodcasts.domain.models.Episode

@Composable
fun PodcastShowEpisodeItem(episode: Episode) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(16.dp)
    ) {
        Row {
            Card(modifier = Modifier.size(width = 80.dp, height = 80.dp)) {
                AsyncImage(model = episode.imageUrl, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight(),
            ) {
                Text(text = episode.title, style = MaterialTheme.typography.headlineSmall)
                Text(text = episode.duration, modifier = Modifier.padding(top = 8.dp))
            }
        }
        Icon(
            imageVector = Icons.Filled.PlayCircleFilled,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview
@Composable
fun PodcastShowEpisodeItemPreview() {
    PodcastShowEpisodeItem(
        Episode(1, "My Episode", "", "14:10")
    )
}