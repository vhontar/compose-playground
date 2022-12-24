package com.example.jetpackcomposelearning.screens.simple

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas

@Composable
fun CustomTextScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                "This is my canvas text",
                100f,
                100f,
                Paint().apply {
                    color = Color.RED
                    textSize = 100f
                }
            )
        }
    }
}