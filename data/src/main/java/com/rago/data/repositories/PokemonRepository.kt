package com.rago.data.repositories

import com.rago.data.model.Pokemons
import com.rago.data.utils.GenericResponse
import kotlinx.coroutines.flow.Flow

//TODO 4.0 creando repositorio
interface PokemonRepository {

    fun getListPokemon(): Flow<GenericResponse<Pokemons>>
}