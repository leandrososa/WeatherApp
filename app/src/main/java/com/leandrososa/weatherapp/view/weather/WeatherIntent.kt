package com.leandrososa.weatherapp.view.weather

sealed class WeatherIntent {
    data class GetWeather(val city: String): WeatherIntent()
    object ShareWeather: WeatherIntent()
    object ReturnToCities: WeatherIntent()
}