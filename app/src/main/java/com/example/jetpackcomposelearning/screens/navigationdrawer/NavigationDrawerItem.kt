package com.example.jetpackcomposelearning.screens.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)
