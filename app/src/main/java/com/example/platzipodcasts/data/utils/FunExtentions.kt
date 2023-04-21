package com.example.platzipodcasts.data.utils

fun Int?.getShowId(): Int {
    return this?.takeIf { true } ?: run {
        throw IllegalArgumentException("showId is required for screen")
    }
}