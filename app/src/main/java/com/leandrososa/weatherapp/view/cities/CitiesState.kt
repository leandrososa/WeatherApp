package com.leandrososa.weatherapp.view.cities

import com.leandrososa.weatherapp.model.Place

sealed class CitiesState {
    data object Loading: CitiesState()
    data object Empty: CitiesState()
    data class DefaultValues(val places: List<Place>): CitiesState()
    data class Success(val places: List<Place>): CitiesState()
}