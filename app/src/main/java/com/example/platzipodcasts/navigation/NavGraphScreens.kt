package com.example.platzipodcasts.navigation

sealed class NavGraphScreens(val route: String) {
    object WelcomeScreen : NavGraphScreens("welcome")
    object ShowsScreen : NavGraphScreens("shows")
    data class EpisodeScreen(val episodeId: Int) : NavGraphScreens("episode/$episodeId")
}