package com.leandrososa.weatherapp.view.weather

import com.leandrososa.weatherapp.model.WeatherResponse

sealed class WeatherState {
    data object Loading: WeatherState()
    data object Error: WeatherState()
    data class Success(var weather: WeatherResponse): WeatherState()

}