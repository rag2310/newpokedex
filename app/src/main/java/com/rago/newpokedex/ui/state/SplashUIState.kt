package com.rago.newpokedex.ui.state

//TODO 3.2 creando ui state
data class SplashUIState(
    val success: Boolean = false,
    val setOnNavHome: (() -> Unit) -> Unit = {},
    val onNavHome: () -> Unit = {}
)