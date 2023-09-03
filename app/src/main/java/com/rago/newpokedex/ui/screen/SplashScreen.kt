package com.rago.newpokedex.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rago.newpokedex.ui.state.SplashUIState

//TODO 3.1 creando pantalla de splash
@Composable
fun SplashScreen(splashUIState: SplashUIState) {
    LaunchedEffect(key1 = splashUIState.success, block = {
        if (splashUIState.success) {
            splashUIState.onNavHome()
        }
    })
    SplashScreenContent()
}

@Composable
private fun SplashScreenContent() {

    val configuration = LocalConfiguration.current
    val width = (configuration.screenWidthDp / 2).dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PokeBall(
                width = width,
                height = width,
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "New PokeDex",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun PokeBall(width: Dp = 100.dp, height: Dp = 100.dp) {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Black.copy(alpha = 0.3f))
            .size(width, height)
            .padding(1.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White)
                )
            }
            Box(
                Modifier
                    .clip(CircleShape)
                    .size(width / 3, height / 3)
                    .background(Color.Black)
                    .align(Alignment.Center)
                    .padding(1.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxSize()
                        .background(Color.White)
                )
            }
        }
    }
}
