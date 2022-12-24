package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposelearning.navigation.NavigationWithSplash
import com.example.jetpackcomposelearning.screens.navigationdrawer.NavigationDrawerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationWithSplash()
        }
    }
}