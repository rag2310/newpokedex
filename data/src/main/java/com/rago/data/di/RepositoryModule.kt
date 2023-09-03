package com.rago.data.di

import com.rago.data.api.PokemonApiService
import com.rago.data.repositories.PokemonRepository
import com.rago.data.repositories.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

//TODO 4.1 creando modulo para repositorios
@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providePokemonRepository(pokemonApiService: PokemonApiService): PokemonRepository =
        PokemonRepositoryImpl(pokemonApiService)
}