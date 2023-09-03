package com.rago.newpokedex.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rago.data.repositories.PokemonRepository
import com.rago.newpokedex.ui.state.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


//TODO 4.2 creando viewmodelHome

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _homeUIState: MutableStateFlow<HomeUIState> = MutableStateFlow(
        HomeUIState()
    )
    val homeUIState: StateFlow<HomeUIState> = _homeUIState.asStateFlow()

    init {
        viewModelScope.launch {
            _homeUIState.update {
                it.copy(loading = true)
            }

            pokemonRepository.getListPokemon().collect { response ->
                response.error?.let {

                }

                response.data?.let {
                    _homeUIState.update { uiState ->
                        uiState.copy(loading = false, result = it.results)
                    }
                }
            }
        }
    }
}