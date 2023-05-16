package com.example.platzipodcasts.presentation.podcastshow.di

import androidx.lifecycle.SavedStateHandle
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.episodes.PagingSourceEpisodes
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.navigation.PODCAST_SHOW_ID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object PodcastShowModule {

    @Provides
    fun providesPagingSourceEpisodes(
        episodesRepository: EpisodesRepository,
        savedStateHandle: SavedStateHandle
    ): Pager<Int, Episode> {
        val showId = checkNotNull(savedStateHandle.get<Int>(PODCAST_SHOW_ID))
        return Pager(
            PagingConfig(pageSize = 50)
        ) {
            PagingSourceEpisodes(episodesRepository, showId)
        }
    }

}