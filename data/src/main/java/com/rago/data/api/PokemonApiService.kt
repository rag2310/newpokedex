package com.rago.data.api


import com.rago.data.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET


//TODO 2.9 creando servicio para consumir endpoints
interface PokemonApiService {

    @GET("pokemon?limit=100000")
    fun getListPokemon(): Call<Pokemons>
}