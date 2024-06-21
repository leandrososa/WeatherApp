package com.leandrososa.weatherapp.view.weather.forecast

import com.leandrososa.weatherapp.model.Coord

sealed class ForecastIntent {
    data class GetForecast(val coord: Coord): ForecastIntent()
}