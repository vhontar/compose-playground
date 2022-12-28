package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.example.jetpackcomposelearning.navigation.NavigationWithSplash
import com.example.jetpackcomposelearning.screens.navigationdrawer.NavigationDrawerScreen
import com.example.jetpackcomposelearning.ui.theme.Shapes
import com.example.jetpackcomposelearning.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationWithSplash()
        }
    }
}