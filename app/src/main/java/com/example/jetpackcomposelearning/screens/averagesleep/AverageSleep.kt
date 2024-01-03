package com.example.jetpackcomposelearning.screens.averagesleep

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelearning.ui.theme.spacing
import kotlin.math.roundToInt

private val color1 = Color(0xFFA79AF0)
private val color2 = Color(0xFFF2F8FF)

private val weekSleepHours = listOf(
    Pair("M", 6),
    Pair("T", 4),
    Pair("W", 10),
    Pair("T", 7),
    Pair("F", 8),
    Pair("S", 9),
    Pair("S", 6)
)

@Composable
fun AverageSleepScreen(
    sleepHours: List<Pair<String, Int>> = weekSleepHours
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color2)
            .padding(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Average sleep",
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Text(
            text = "${weekSleepHours.map { it.second }.average().roundToInt()} hours last week",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold,
            color = Color.LightGray,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        AverageSleepBar(
            weekSleepHours = sleepHours,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun AverageSleepBar(
    weekSleepHours: List<Pair<String, Int>>,
    modifier: Modifier = Modifier,
    sleepBarItemWidth: Dp = 18.dp,
    sleepBarHeight: Dp = 140.dp
) {
    var barSpacingPx by remember {
        mutableStateOf(0f)
    }

    Column(modifier = modifier) {
        Canvas(modifier = Modifier
            .height(sleepBarHeight)
            .fillMaxWidth()
        ) {
            val padding = 30f
            val itemWidth = (size.width - sleepBarItemWidth.toPx()) / (weekSleepHours.size - 1)
            val maxValue = weekSleepHours.maxOf { it.second }
            barSpacingPx = itemWidth - padding

            weekSleepHours.forEachIndexed { index, pair ->
                val itemHeight = size.height - (pair.second.toFloat() / maxValue) * size.height
                drawLine(
                    color = color1,
                    start = Offset(index * itemWidth + padding, size.height - padding),
                    end = Offset(index * itemWidth + padding, itemHeight + padding),
                    strokeWidth = sleepBarItemWidth.toPx(),
                    cap = StrokeCap.Round
                )
            }
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val dp = with(LocalDensity.current) {
                barSpacingPx.toDp()
            }
            weekSleepHours.forEachIndexed { index, pair ->
                Text(
                    text = pair.first,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = if (index == 0) 0.dp else dp)
                )
            }
        }
    }
}


