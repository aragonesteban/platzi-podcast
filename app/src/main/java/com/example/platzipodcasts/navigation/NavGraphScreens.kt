package com.example.platzipodcasts.navigation

const val PODCAST_SHOW_ID = "podcastShowId"

sealed class NavGraphScreens(val route: String) {
    object WelcomeScreen : NavGraphScreens("welcome")
    object HomeScreen : NavGraphScreens("shows")
    data class PodcastShowScreen(val podcastShowId: Int = 0) : NavGraphScreens(
        route = "podcast-show/{$PODCAST_SHOW_ID}"
    ) {
        val routeWithId: String
            get() = "podcast-show/$podcastShowId"
    }

    object EpisodeScreen : NavGraphScreens("episode/{episodeId}")
}