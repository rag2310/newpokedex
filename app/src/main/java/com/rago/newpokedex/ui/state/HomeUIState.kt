package com.rago.newpokedex.ui.state

import com.rago.data.model.Pokemons
import com.rago.data.model.Result

//TODO 4.2 creando uistate
data class HomeUIState(
    val loading: Boolean = false,
    val result: List<Result> = listOf()
)