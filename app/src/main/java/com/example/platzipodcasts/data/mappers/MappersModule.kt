package com.example.platzipodcasts.data.mappers

import com.example.platzipodcasts.data.repository.remote.shows.ShowResponse
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
    ): PodcastMapper<ShowResponse, ArrayList<PodcastShow>>

}