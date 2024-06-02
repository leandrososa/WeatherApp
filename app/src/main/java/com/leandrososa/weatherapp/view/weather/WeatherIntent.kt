package com.leandrososa.weatherapp.view.weather

sealed class WeatherIntent {
    object LoadWeather : WeatherIntent()
    object ShowError : WeatherIntent()
    object ShowLoading : WeatherIntent()
}