package com.leandrososa.weatherapp.model

data class City (
    var name: String,
    var weatherDescription: String,
    var currentTemperature: Double,
    var lat: Double?,
    var lon: Double?,
    var weatherIcon: String?,
    var dayTemps: List<DayTemp>?
)