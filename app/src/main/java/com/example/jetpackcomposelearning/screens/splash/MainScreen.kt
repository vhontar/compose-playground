package com.example.jetpackcomposelearning.screens.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposelearning.navigation.allScreens
import com.example.jetpackcomposelearning.ui.theme.CustomMaterialTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController) {
    CustomMaterialTheme {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(90.dp),
            content = {
                items(allScreens.size) { i ->
                    val screen = allScreens[i]
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.DarkGray)
                            .clickable { navController.navigate(screen.route) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = screen.title,
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(10.dp)
                        )
                    }
                }
            }
        )
    }
}