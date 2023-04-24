package com.example.platzipodcasts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.platzipodcasts.presentation.episode.EpisodeScreen
import com.example.platzipodcasts.presentation.home.HomeScreen
import com.example.platzipodcasts.presentation.podcastshow.PodcastShowScreen
import com.example.platzipodcasts.presentation.welcome.WelcomeScreen

@Composable
fun NavConfig() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavGraphScreens.WelcomeScreen.route) {
        composable(NavGraphScreens.WelcomeScreen.route) {
            WelcomeScreen {
                navController.navigate(NavGraphScreens.HomeScreen.route)
            }
        }

        composable(NavGraphScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(
            NavGraphScreens.PodcastShowScreen().route,
            arguments = listOf(navArgument(name = PODCAST_SHOW_ID) {
                type = NavType.IntType
            })
        ) {
            PodcastShowScreen(
                podcastShowId = it.arguments?.getInt(PODCAST_SHOW_ID) ?: 0,
                navController = navController
            )
        }

        composable(
            NavGraphScreens.EpisodeScreen().route,
            arguments = listOf(navArgument(name = EPISODE_ID) { type = NavType.IntType })
        ) {
            EpisodeScreen(episodeId = it.arguments?.getInt(EPISODE_ID) ?: 0)
        }
    }
}