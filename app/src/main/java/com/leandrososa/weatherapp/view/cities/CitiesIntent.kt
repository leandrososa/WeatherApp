package com.leandrososa.weatherapp.view.cities

sealed class CitiesIntent {
    data class Search(val query: String): CitiesIntent()
    data class GoToWeather(val lat: Double, val lon: Double): CitiesIntent()
    object UseGeo: CitiesIntent()
}