package com.example.jetpackcomposelearning.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.jetpackcomposelearning.screens.splash.MainScreen
import com.example.jetpackcomposelearning.screens.splash.SplashScreen

@Composable
fun NavigationWithSplash() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(route = Screen.MainScreen.route) { MainScreen(navController) }
        allScreens.forEach { screen ->
            composable(
                route = screen.route,
                deepLinks = listOf(
                    navDeepLink {
                        uriPattern = "https://compose-playground.com/${screen.route}"
                        action = Intent.ACTION_VIEW
                    }
                ) // doesn't work with Android 12 and higher (website should be real)
            ) { screen.asComposable() }
        }
    }
}