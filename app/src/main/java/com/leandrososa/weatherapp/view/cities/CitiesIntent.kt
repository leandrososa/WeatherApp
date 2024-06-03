package com.leandrososa.weatherapp.view.cities

sealed class CitiesIntent {
    data class Search(val query: String): CitiesIntent()
    object UseGeo: CitiesIntent()
}