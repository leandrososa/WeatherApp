package com.leandrososa.weatherapp.view.cities

import androidx.lifecycle.ViewModel
import com.leandrososa.weatherapp.model.City

class CitiesViewModel: ViewModel() {
    var cities = listOf(
        City(
            name = "Buenos Aires",
            weatherDescription = "Cloudy",
            currentTemperature = 11.7,
            lat = null,
            lon = null,
            weatherIcon = null,
            dayTemps = null
        ),
        City(
            name = "Bahía Blanca",
            weatherDescription = "Sunny",
            currentTemperature = 18.3,
            lat = null,
            lon = null,
            weatherIcon = null,
            dayTemps = null
        )
    )
}