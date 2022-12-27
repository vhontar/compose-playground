package com.example.jetpackcomposelearning.screens.incomeexpenses

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelearning.ui.theme.Shapes
import com.example.jetpackcomposelearning.ui.theme.Typography
import com.example.jetpackcomposelearning.ui.theme.spacing

private val color1: Color = Color(0xFF85EFED)
private val color2: Color = Color(0xFFFFEBA5)

@Composable
fun IncomeExpensesScreen(
    income: Float = 12345.22f,
    expenses: Float = 4789.99f
) {
    val expensesPercent = expenses / income * 360f
    val incomePercent = 360f - expensesPercent

    val animateIncomeAmount = remember { Animatable(0f) }
    LaunchedEffect(animateIncomeAmount) {
        animateIncomeAmount.animateTo(
            targetValue = income,
            animationSpec = tween(
                durationMillis = 600,
                easing = LinearEasing
            )
        )
    }

    val animateExpensesAmount = remember { Animatable(0f) }
    LaunchedEffect(animateExpensesAmount) {
        animateExpensesAmount.animateTo(
            targetValue = expenses,
            animationSpec = tween(
                durationMillis = 600,
                easing = LinearEasing
            )
        )
    }

    val animateIncomeArc = remember { Animatable(0f) }
    LaunchedEffect(animateIncomeArc) {
        animateIncomeArc.animateTo(
            targetValue = incomePercent,
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        )
    }

    val animateExpensesArc = remember { Animatable(0f) }
    LaunchedEffect(animateExpensesArc) {
        animateExpensesArc.animateTo(
            targetValue = expensesPercent - 10f,
            animationSpec = tween(
                durationMillis = 300,
                delayMillis = 300,
                easing = LinearEasing
            )
        )
    }

    MaterialTheme(
        typography = Typography,
        shapes = Shapes
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.medium),
                contentAlignment = Alignment.Center
            ) {
                IncomeExpenseCircle(
                    animateIncomeArc = animateIncomeArc,
                    incomePercent = incomePercent,
                    animateExpensesArc = animateExpensesArc
                )
                IncomeValue(
                    animateIncomeAmount = animateIncomeAmount,
                    modifier = Modifier.Companion
                        .align(Alignment.Center)
                        .padding(MaterialTheme.spacing.medium)
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            ExpensesValue(animateExpensesAmount)
        }
    }
}

@Composable
private fun IncomeValue(
    animateIncomeAmount: Animatable<Float, AnimationVector1D>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Income",
            style = MaterialTheme.typography.h4,
            color = Color.LightGray
        )
        Text(
            text = "$${animateIncomeAmount.value}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h1,
            color = Color.Black
        )
    }
}

@Composable
private fun IncomeExpenseCircle(
    animateIncomeArc: Animatable<Float, AnimationVector1D>,
    incomePercent: Float,
    animateExpensesArc: Animatable<Float, AnimationVector1D>
) {
    Canvas(
        modifier = Modifier.size(250.dp)
    ) {
        drawArc(
            color = color1,
            startAngle = 90f,
            sweepAngle = animateIncomeArc.value,
            useCenter = false,
            style = Stroke(
                width = 20.dp.toPx(),
                cap = StrokeCap.Butt
            )
        )

        drawArc(
            color = color2,
            startAngle = 95f + incomePercent,
            sweepAngle = animateExpensesArc.value,
            useCenter = false,
            style = Stroke(
                width = 20.dp.toPx(),
                cap = StrokeCap.Butt
            )
        )
    }
}

@Composable
private fun ExpensesValue(animateExpensesAmount: Animatable<Float, AnimationVector1D>) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$${animateExpensesAmount.value}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2,
            color = Color.Black
        )
        Text(
            text = "Expenses",
            style = MaterialTheme.typography.h4,
            color = Color.LightGray
        )
    }
}