package com.leandrososa.weatherapp.view.weather

import com.leandrososa.weatherapp.model.Coord

sealed class WeatherIntent {
    data class GetWeather(val coord: Coord): WeatherIntent()
    object ShareWeather: WeatherIntent()
    object ReturnToCities: WeatherIntent()
}