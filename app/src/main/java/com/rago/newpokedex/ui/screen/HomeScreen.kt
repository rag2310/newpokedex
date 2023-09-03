package com.rago.newpokedex.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rago.newpokedex.ui.state.HomeUIState

//TODO 4.2 creando vista home
@Composable
fun HomeScreen(homeUIState: HomeUIState) {

    if (homeUIState.loading) {
        Column(
            Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                CircularProgressIndicator()
                Text(text = "Cargando")
            }
        }
    } else {
        if (homeUIState.result.isNotEmpty()) {
            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                items(homeUIState.result) {
                    Card(modifier = Modifier.padding(10.dp)) {
                        Text(modifier = Modifier.padding(10.dp), text = it.name)
                    }
                }
            })
        } else {
            Column(
                Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column {
                    Icon(Icons.Filled.Close, contentDescription = null)
                    Text(text = "Sin Datos")
                }
            }
        }
    }
}