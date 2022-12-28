package com.example.jetpackcomposelearning.navigation

import androidx.compose.runtime.Composable
import com.example.jetpackcomposelearning.averagesleep.AverageSleepScreen
import com.example.jetpackcomposelearning.screens.animateddropdown.AnimatedDropdownScreen
import com.example.jetpackcomposelearning.screens.bottomnavigation.BottomNavigationScreen
import com.example.jetpackcomposelearning.screens.bottomsheet.BottomSheetScreen
import com.example.jetpackcomposelearning.screens.clock.ClockScreen
import com.example.jetpackcomposelearning.screens.incomeexpenses.IncomeExpensesScreen
import com.example.jetpackcomposelearning.screens.instagram.InstagramScreen
import com.example.jetpackcomposelearning.screens.meditation.MeditationScreen
import com.example.jetpackcomposelearning.screens.motionlayout.MotionLayoutScreen
import com.example.jetpackcomposelearning.screens.navigationdrawer.NavigationDrawerScreen
import com.example.jetpackcomposelearning.screens.pagination.PaginationScreen
import com.example.jetpackcomposelearning.screens.parallaxscrollview.ParallaxScrollScreen
import com.example.jetpackcomposelearning.screens.scale.ScaleScreen
import com.example.jetpackcomposelearning.screens.soundbar.SoundbarScreen
import com.example.jetpackcomposelearning.screens.timer.TimerScreen
import com.example.jetpackcomposelearning.ui.theme.CustomMaterialTheme

val allScreens = listOf(
    Screen.InstagramScreen,
    Screen.MeditationScreen,
    Screen.ScaleScreen,
    Screen.ClockScreen,
    Screen.SoundBarScreen,
    Screen.TimerScreen,
    Screen.ParallaxScrollViewScreen,
    Screen.AnimatedDropdownScreen,
    Screen.BottomNavigationScreen,
    Screen.BottomSheetScreen,
    Screen.CustomPaginationScreen,
    Screen.NavigationDrawerScreen,
    Screen.MotionLayoutScreen,
    Screen.ExpensesScreen,
    Screen.AverageSleepScreen
)

sealed class Screen(
    val route: String,
    val title: String,
    private val content: (@Composable () -> Unit)? = null
) {
    object SplashScreen : Screen(
        route = "splash_screen",
        title = "Splash screen"
    )

    object MainScreen : Screen(
        route = "main_screen",
        title = "Main Screen"
    )

    object AnimatedDropdownScreen : Screen(
        route = "animated_dropdown_screen",
        title = "Animated dropdown",
        content = { AnimatedDropdownScreen() }
    )

    object BottomNavigationScreen : Screen(
        route = "bottom_navigation_screen",
        title = "Bottom Navigation",
        content = { BottomNavigationScreen() }
    )

    object BottomSheetScreen : Screen(
        route = "bottom_sheet_screen",
        title = "Bottom sheet",
        content = { BottomSheetScreen() }
    )

    object InstagramScreen : Screen(
        route = "instagram_screen",
        title = "Instagram App",
        content = { InstagramScreen() }
    )

    object MeditationScreen : Screen(
        route = "meditation_screen",
        title = "Meditation App",
        content = { MeditationScreen() }
    )

    object CustomPaginationScreen : Screen(
        route = "custom_pagination_screen",
        title = "Custom pagination",
        content = { PaginationScreen() }
    )

    object ParallaxScrollViewScreen : Screen(
        route = "parallax_scroll_view_screen",
        title = "Parallax scroll view",
        content = { ParallaxScrollScreen() }
    )

    object ScaleScreen : Screen(
        route = "scale_screen_screen",
        title = "Scale",
        content = { ScaleScreen() }
    )

    object SoundBarScreen : Screen(
        route = "sound_bar_screen",
        title = "Sound bar",
        content = { SoundbarScreen() }
    )

    object TimerScreen : Screen(
        route = "timer_screen",
        title = "Timer",
        content = { TimerScreen() }
    )

    object NavigationDrawerScreen : Screen(
        route = "navigation_drawer_screen",
        title = "Navigation Drawer",
        content = { NavigationDrawerScreen() }
    )

    object MotionLayoutScreen : Screen(
        route = "motion_layout_screen",
        title = "Motion Layout",
        content = { MotionLayoutScreen() }
    )

    object ClockScreen : Screen(
        route = "clock_screen",
        title = "Clock",
        content = { ClockScreen() }
    )
    object ExpensesScreen : Screen(
        route = "expenses_screen",
        title = "Income & Expenses",
        content = {
            CustomMaterialTheme {
                IncomeExpensesScreen()
            }
        }
    )
    object AverageSleepScreen : Screen(
        route = "average_sleep_screen",
        title = "Average sleep screen",
        content = {
            CustomMaterialTheme {
                AverageSleepScreen()
            }
        }
    )

    @Composable
    fun asComposable() = content?.invoke()

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}
