package com.example.jetpackcomposelearning.screens.scale

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import java.lang.Math.PI
import kotlin.math.*

@Composable
fun ScaleScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scale(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter),
            style = ScaleStyle(
                scaleWidth = 150.dp
            )
        ) {

        }
    }
}

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 250,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit
) {
    val radius = style.radius
    val scaleWidth = style.scaleWidth
    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableStateOf(0f)
    }
    var dragStartedAngle by remember {
        mutableStateOf(0f)
    }
    var oldAngle by remember {
        mutableStateOf(angle)
    }

    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectDragGestures(
                    onDragStart = { offset ->
                        dragStartedAngle = -atan2(
                            circleCenter.x - offset.x,
                            circleCenter.y - offset.y
                        ) * (180f / PI.toFloat())
                    },
                    onDragEnd = {
                        oldAngle = angle
                    }
                ) { change, _ ->
                    // TODO: play around
                    val touchAngle = -atan2(
                        circleCenter.x - change.position.x,
                        circleCenter.y - change.position.y
                    ) * (180f / PI.toFloat())

                    val newAngle = oldAngle + (touchAngle - dragStartedAngle)

                    // TODO: play around
                    angle = newAngle.coerceIn(
                        minimumValue = initialWeight - maxWeight.toFloat(),
                        maximumValue = initialWeight - minWeight.toFloat()
                    )

                    onWeightChange((initialWeight - angle).roundToInt())
                }
            }
    ) {
        // TODO: play around
        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2

        center = this.center
        circleCenter = Offset(
            center.x,
            outerRadius
        )

        // draw circle
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius.toPx(),
                Paint().apply {
                    strokeWidth = scaleWidth.toPx()
                    color = android.graphics.Color.WHITE
                    setStyle(Paint.Style.STROKE)

                    // shadow
                    setShadowLayer(
                        60f,
                        0f,
                        0f,
                        android.graphics.Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        // draw lines
        for (i in minWeight..maxWeight) {
            val angleInRadiance = (i - initialWeight + angle - 90) * (PI / 180f) .toFloat()

            val lineType = when {
                i % 10 == 0 -> LineType.TenStep
                i % 5 == 0 -> LineType.FiveStep
                else -> LineType.Normal
            }

            // TODO: play around
            val lineLength = when(lineType) {
                LineType.Normal -> style.normalLineLength.toPx()
                LineType.FiveStep -> style.fiveStepLineLength.toPx()
                LineType.TenStep -> style.tenStepLineLength.toPx()
            }

            // TODO: play around
            val lineColor = when(lineType) {
                LineType.Normal -> style.normalLineColor
                LineType.FiveStep -> style.fiveStepLineColor
                LineType.TenStep -> style.tenStepLineColor
            }

            // TODO: play around
            val lineStart = Offset(
                x = (outerRadius - lineLength) * cos(angleInRadiance) + circleCenter.x,
                y = (outerRadius - lineLength) * sin(angleInRadiance) + circleCenter.y
            )

            // TODO: play around
            val lineEnd = Offset(
                x = outerRadius * cos(angleInRadiance) + circleCenter.x,
                y = outerRadius * sin(angleInRadiance) + circleCenter.y
            )

            drawContext.canvas.nativeCanvas.apply {
                if (lineType == LineType.TenStep) {
                    // TODO: play around
                    val textRadius = outerRadius - lineLength - 5.dp.toPx() - style.textSize.toPx()
                    val x = textRadius * cos(angleInRadiance) + circleCenter.x
                    val y = textRadius * sin(angleInRadiance) + circleCenter.y
                    withRotation(
                        degrees = angleInRadiance * (180f / PI.toFloat()) + 90f,
                        pivotX = x,
                        pivotY = y
                    ) {
                        drawText(
                            abs(i).toString(),
                            x,
                            y,
                            Paint().apply {
                                textSize = style.textSize.toPx()
                                textAlign = Paint.Align.CENTER
                            }
                        )
                    }
                }
            }

            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd,
                strokeWidth = 1.dp.toPx()
            )

            val middleTop = Offset(
                x = circleCenter.x,
                y = circleCenter.y - innerRadius - style.scaleIndicatorLength.toPx()
            )

            val bottomLeft = Offset(
                x = circleCenter.x - 8f,
                y = circleCenter.y - innerRadius
            )

            val bottomRight = Offset(
                x = circleCenter.x + 8f,
                y = circleCenter.y - innerRadius
            )

            // TODO: play around
            val indicator = Path().apply {
                moveTo(middleTop.x, middleTop.y)
                lineTo(bottomLeft.x, bottomLeft.y)
                lineTo(bottomRight.x, bottomRight.y)
                lineTo(middleTop.x, middleTop.y)
            }

            drawPath(
                path = indicator,
                color = style.scaleIndicatorColor
            )
        }
    }
}