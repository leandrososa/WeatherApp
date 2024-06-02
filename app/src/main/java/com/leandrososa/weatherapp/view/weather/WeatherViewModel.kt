package com.leandrososa.weatherapp.view.weather

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {

    val city = mutableStateOf<String>("Beccar")
    val temp = mutableStateOf<Double>(16.5)
    val weatherDescription = mutableStateOf<String>("Nublado")

    fun updateWeather() {

    }
}