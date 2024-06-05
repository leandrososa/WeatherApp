package com.leandrososa.weatherapp.view.cities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.leandrososa.weatherapp.model.Place
import com.leandrososa.weatherapp.repository.IRepository
import com.leandrososa.weatherapp.repository.MockRepository
import kotlinx.coroutines.launch

class CitiesViewModel(val repo: IRepository): ViewModel() {

    companion object{
        val factory: ViewModelProvider.Factory = viewModelFactory{
            initializer {
                val repo = MockRepository()
                CitiesViewModel(repo)
            }
        }
    }

    var searchText =  mutableStateOf("")
    var places = listOf(
        Place(
            name = "Buenos Aires",
            lat = -34.61,
            lon = -58.38,
            country = "AR",
            state = "Buenos Aires"
        ),
        Place(
            name = "Bahía Blanca",
            lat = -38.72,
            lon = -62.27,
            country = "AR",
            state = "Buenos Aires"
        ),
        Place(
            name = "Córdoba",
            lat = -31.42,
            lon = -64.18,
            country = "AR",
            state = "Córdoba"
        ),
        Place(
            name = "Rosario",
            lat = -32.95,
            lon = -60.64,
            country = "AR",
            state = "Santa Fe"
        ),
        Place(
            name = "Misiones",
            lat = -27.37,
            lon = -55.90,
            country = "AR",
            state = "Misiones"
        ),
        Place(
            name = "La Plata",
            lat = -34.92,
            lon = -57.95,
            country = "AR",
            state = "Buenos Aires"
        )
    )

    var uiState by mutableStateOf<CitiesState>(CitiesState.DefaultValues(places))

    fun execute(intent: CitiesIntent){
        when(intent){
            is CitiesIntent.UseGeo -> useGeo()
            is CitiesIntent.Search -> search(intent.query)
        }
    }

    private fun useGeo(){
        //todo: add get geo
    }

    private fun search(query: String){
        uiState = CitiesState.Loading
        viewModelScope.launch {
            try {
                val searchResponse = repo.search(query)
                if (searchResponse.places.isEmpty()) {
                    uiState = CitiesState.Empty
                } else {
                    uiState = CitiesState.Success(searchResponse.places)
                }
            } catch(ex: Exception){
                uiState = CitiesState.DefaultValues(places)
                //todo: show error on snack bar
            }

        }
    }
}