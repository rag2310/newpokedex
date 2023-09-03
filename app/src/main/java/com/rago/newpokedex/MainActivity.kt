package com.rago.newpokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rago.data.utils.navigateWithPopUp
import com.rago.newpokedex.ui.screen.HomeScreen
import com.rago.newpokedex.ui.screen.SplashScreen
import com.rago.newpokedex.ui.state.HomeUIState
import com.rago.newpokedex.ui.state.SplashUIState
import com.rago.newpokedex.ui.theme.NewPokeDexTheme
import com.rago.newpokedex.ui.viewmodel.HomeViewModel
import com.rago.newpokedex.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

//TODO 2.11 agregando anotaciones para configurar hilt
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewPokeDexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewPokeDexNavHost()
                }
            }
        }
    }
}


//TODO 3.0 agregando navigation compose
@Composable
private fun NewPokeDexNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            //TODO 3.4 pasar la uistate a la ui
            val splashViewModel: SplashViewModel = hiltViewModel()
            val splashUIState: SplashUIState by splashViewModel.splashUIState.collectAsState()
            LaunchedEffect(key1 = Unit, block = {
                splashUIState.setOnNavHome {
                    navController.navigateWithPopUp("home", "splash")
                }
            })
            SplashScreen(splashUIState)
        }

        composable("home") {
            //TODO 4.3 pasar uistate a la ui
            val homeViewModel: HomeViewModel = hiltViewModel()
            val homeUIState:HomeUIState by homeViewModel.homeUIState.collectAsState()
            HomeScreen(homeUIState)
        }
    }
}