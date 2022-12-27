package com.example.jetpackcomposelearning.screens.clock

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClockScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(150.dp)
        ) {
//            drawContext.canvas.nativeCanvas.apply {
//                drawCircle(
//                    0f,
//                    0f,
//                    75.dp.toPx(),
//                    Paint().apply {
//                        strokeWidth = 150.dp.toPx()
//                        color = android.graphics.Color.WHITE
//                        setStyle(Paint.Style.STROKE)
//
//                        // shadow
//                        setShadowLayer(
//                            60f,
//                            0f,
//                            0f,
//                            android.graphics.Color.argb(50, 0, 0, 0)
//                        )
//                    }
//                )
//            }
        }
    }
}