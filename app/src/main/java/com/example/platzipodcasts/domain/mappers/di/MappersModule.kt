package com.example.platzipodcasts.domain.mappers.di

import com.example.platzipodcasts.domain.mappers.EpisodesMapper
import com.example.platzipodcasts.domain.utils.PodcastMapper
import com.example.platzipodcasts.domain.mappers.PodcastShowsMapper
import com.example.platzipodcasts.domain.mappers.ShowMapper
import com.example.platzipodcasts.data.remote.episodes.EpisodesResponse
import com.example.platzipodcasts.data.remote.shows.PodcastShowsResponse
import com.example.platzipodcasts.data.remote.shows.ShowDetailResponse
import com.example.platzipodcasts.domain.models.Episodes
import com.example.platzipodcasts.domain.models.PodcastShow
import com.example.platzipodcasts.domain.models.ShowDetail
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindsPodcastShowsMapper(
        showsMapper: PodcastShowsMapper
    ): PodcastMapper<PodcastShowsResponse, ArrayList<PodcastShow>>

    @Binds
    abstract fun bindsEpisodesMapper(
        episodesMapper: EpisodesMapper
    ): PodcastMapper<EpisodesResponse, Episodes>

    @Binds
    abstract fun bindsShowsMapper(
        showMapper: ShowMapper
    ): PodcastMapper<ShowDetailResponse, ShowDetail>

}