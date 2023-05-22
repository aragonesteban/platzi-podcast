package com.example.platzipodcasts.domain.utils

interface PodcastMapper<I, O> {
    fun map(input: I): O
}
