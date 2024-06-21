package com.leandrososa.weatherapp.view.weather.forecast

import com.leandrososa.weatherapp.model.ForecastResponse

sealed class ForecastState {
    data object Loading: ForecastState()
    data object Error: ForecastState()
    data class Success(var forecast: ForecastResponse): ForecastState()
}