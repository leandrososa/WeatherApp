package com.leandrososa.weatherapp.model

data class WeatherResponse(
    val coord: Coord,
    val weather: List<WeatherDesc>,
    val base: String,
    val main: WeatherMain,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: WeatherSys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)

data class WeatherSys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)