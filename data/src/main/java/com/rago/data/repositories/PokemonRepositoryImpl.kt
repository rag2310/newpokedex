package com.rago.data.repositories

import com.rago.data.api.PokemonApiService
import com.rago.data.model.Pokemons
import com.rago.data.utils.GenericResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//TODO 4.0 creando repositorio
class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getListPokemon(): Flow<GenericResponse<Pokemons>> = callbackFlow {

        val callback = object : Callback<Pokemons> {
            override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
                trySend(GenericResponse(data = response.body()))
            }

            override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                trySend(GenericResponse(error = t.message))
            }
        }

        val api = pokemonApiService.getListPokemon()

        api.enqueue(callback)

        awaitClose {
            if (api.isCanceled) {
                api.cancel()
            }
        }
    }
}