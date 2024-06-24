package com.leandrososa.weatherapp.view.cities

import android.content.Context

sealed class CitiesIntent {
    data class Search(val query: String): CitiesIntent()
    data class GoToWeather(val lat: Float, val lon: Float): CitiesIntent()
    data class UseGeo(val context: Context): CitiesIntent()
}