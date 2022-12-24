package com.example.jetpackcomposelearning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposelearning.screens.splash.MainScreen
import com.example.jetpackcomposelearning.screens.splash.SplashScreen

@Composable
fun NavigationWithSplash() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(route = Screen.MainScreen.route) { MainScreen(navController) }
        allScreens.forEach { screen ->
            composable(route = screen.route) { screen.asComposable() }
        }
    }
}