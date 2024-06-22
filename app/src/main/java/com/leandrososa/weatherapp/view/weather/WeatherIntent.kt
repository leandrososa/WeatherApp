package com.leandrososa.weatherapp.view.weather

import android.content.Context
import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.model.WeatherResponse

sealed class WeatherIntent {
    data class GetWeather(val coord: Coord): WeatherIntent()
    data class ShareWeather(val context: Context, val weather: WeatherResponse): WeatherIntent()
    object ReturnToCities: WeatherIntent()
}