package com.example.jetpackcomposelearning.screens.changeappicon

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.R

@Composable
fun ChangeAppIconScreen() {
    val context = LocalContext.current
    val packageManager = context.packageManager
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Change App Icon",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        packageManager.setComponentEnabledSetting(
                            ComponentName(
                                context,
                                "${context.packageName}.MainActivity"
                            ),
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP
                        )
                        packageManager.setComponentEnabledSetting(
                            ComponentName(
                                context,
                                "${context.packageName}.MainActivityAlias"
                            ),
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP
                        )
                    },
                painter = painterResource(id = R.drawable.ic_launcher),
                contentDescription = "Green launcher"
            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        packageManager.setComponentEnabledSetting(
                            ComponentName(
                                context,
                                "${context.packageName}.MainActivity"
                            ),
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP
                        )
                        packageManager.setComponentEnabledSetting(
                            ComponentName(
                                context,
                                "${context.packageName}.MainActivityAlias"
                            ),
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP
                        )
                    },
                painter = painterResource(id = R.drawable.ic_launcher_2),
                contentDescription = "Blue launcher"
            )
        }
    }
}