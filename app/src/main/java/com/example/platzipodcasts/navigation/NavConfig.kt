package com.example.platzipodcasts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.platzipodcasts.features.shows.ShowsScreen
import com.example.platzipodcasts.features.welcome.WelcomeScreen

@Composable
fun NavConfig() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavGraphScreens.WelcomeScreen.route) {
        composable(NavGraphScreens.WelcomeScreen.route) {
            WelcomeScreen(navigateToHome = {
                navController.navigate(NavGraphScreens.ShowsScreen.route)
            })
        }
        composable(NavGraphScreens.ShowsScreen.route) { ShowsScreen() }
    }
}