package com.example.jetpackcomposelearning.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.R

val lexend = FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_extra_light, FontWeight.ExtraLight),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_extra_bold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
        body1 = TextStyle(
                color = AquaBlue,
                fontFamily = lexend,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
        ),
        h1 = TextStyle(
                color = TextWhite,
                fontFamily = lexend,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
        ),
        h2 = TextStyle(
                color = TextWhite,
                fontFamily = lexend,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
        )
)