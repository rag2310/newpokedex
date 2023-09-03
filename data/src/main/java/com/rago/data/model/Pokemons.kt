package com.rago.data.model

//TODO: 2.8 agegando estructura para peticion
data class Pokemons(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)