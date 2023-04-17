package com.example.platzipodcasts.data.repository.di

import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepositoryImpl
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPodcastShowsRepository(
        showsRepositoryImpl: ShowsRepositoryImpl
    ): ShowsRepository

    @Binds
    abstract fun bindsEpisodesRepository(
        episodesRepositoryImpl: EpisodesRepositoryImpl
    ): EpisodesRepository

}