package com.example.jetpackcomposelearning

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): WindowInfo {
    val localConfiguration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            localConfiguration.screenWidthDp < 600 -> WindowInfo.WindowType.Compat
            localConfiguration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            localConfiguration.screenHeightDp < 480 -> WindowInfo.WindowType.Compat
            localConfiguration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenWidth = localConfiguration.screenWidthDp.dp,
        screenHeight = localConfiguration.screenHeightDp.dp
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
) {
    sealed interface WindowType {
        object Compat: WindowType
        object Medium: WindowType
        object Expanded: WindowType
    }
}