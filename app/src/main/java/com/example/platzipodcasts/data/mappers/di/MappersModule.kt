package com.example.platzipodcasts.data.mappers.di

import com.example.platzipodcasts.data.mappers.EpisodesMapper
import com.example.platzipodcasts.data.mappers.PodcastMapper
import com.example.platzipodcasts.data.mappers.ShowsMapper
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.data.remote.shows.ShowsResponse
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.PodcastShow
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindsPodcastShowsMapper(
        showsMapper: ShowsMapper
    ): PodcastMapper<ShowsResponse, ArrayList<PodcastShow>>

    @Binds
    abstract fun bindsEpisodesMapper(
        episodesMapper: EpisodesMapper
    ): PodcastMapper<EpisodesResponse, ArrayList<Episode>>

}