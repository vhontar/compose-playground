package com.example.jetpackcomposelearning.screens.simple

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun ColorBoxScreen(modifier: Modifier = Modifier) {
    var color by remember {
        mutableStateOf(Color.Yellow)
    }

    Box(
        modifier = modifier
            .background(color)
            .clickable {
                color = Color(
                    Random.nextInt(0, 255),
                    Random.nextInt(0, 255),
                    Random.nextInt(0, 255)
                )
            }
    )
}