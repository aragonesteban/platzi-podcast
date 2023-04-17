package com.example.platzipodcasts.data.remote.di

import com.example.platzipodcasts.data.remote.episodes.EpisodesApi
import com.example.platzipodcasts.data.remote.shows.ShowsApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val SPEAKER_API = "https://api.spreaker.com/"

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(SPEAKER_API)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun providesPodcastShowsApi(retrofit: Retrofit): ShowsApi {
        return retrofit.create(ShowsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesEpisodesApi(retrofit: Retrofit): EpisodesApi {
        return retrofit.create(EpisodesApi::class.java)
    }

}