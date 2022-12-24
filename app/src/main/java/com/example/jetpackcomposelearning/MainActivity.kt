package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposelearning.navigation.Navigation
import com.example.jetpackcomposelearning.navigation.SplashNavigation
import com.example.jetpackcomposelearning.screens.animateddropdown.AnimatedDropdownScreen
import com.example.jetpackcomposelearning.screens.bottomnavigation.BottomNavigationScreen
import com.example.jetpackcomposelearning.screens.bottomsheet.BottomSheetScreen
import com.example.jetpackcomposelearning.screens.instagram.InstagramScreen
import com.example.jetpackcomposelearning.screens.meditation.MeditationScreen
import com.example.jetpackcomposelearning.screens.motionlayout.MotionLayoutScreen
import com.example.jetpackcomposelearning.screens.pagination.PaginationScreen
import com.example.jetpackcomposelearning.screens.pagination.PaginationViewModel
import com.example.jetpackcomposelearning.screens.parallaxscrollview.ParallaxScrollScreen
import com.example.jetpackcomposelearning.screens.simple.CustomProgressBarScreen
import com.example.jetpackcomposelearning.screens.simple.MultiSelectScreen
import com.example.jetpackcomposelearning.screens.soundbar.SoundbarScreen
import com.example.jetpackcomposelearning.screens.timer.TimerScreen
import com.example.jetpackcomposelearning.ui.theme.MeditationUIYouTubeTheme
import com.example.jetpackcomposelearning.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // PaginationScreen(viewModel = viewModel<PaginationViewModel>())
            BottomSheetScreen()
        }
    }
}