package com.leandrososa.weatherapp.repository

import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.model.ForecastResponse
import com.leandrososa.weatherapp.model.SearchResponse
import com.leandrososa.weatherapp.model.WeatherResponse

interface IRepository {
    suspend fun search(cityName: String): SearchResponse
    suspend fun getWeather(coord: Coord): WeatherResponse
    suspend fun getForecast(coord: Coord): ForecastResponse
}