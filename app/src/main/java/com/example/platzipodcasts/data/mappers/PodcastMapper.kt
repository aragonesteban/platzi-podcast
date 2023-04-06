package com.example.platzipodcasts.data.mappers

interface PodcastMapper<I, O> {
    fun map(input: I): O
}
