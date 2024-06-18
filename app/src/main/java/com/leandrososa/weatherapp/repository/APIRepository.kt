package com.leandrososa.weatherapp.repository

import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.model.ForecastResponse
import com.leandrososa.weatherapp.model.SearchResponse
import com.leandrososa.weatherapp.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class APIRepository : IRepository {

    // create api key variable
    private val apiKey = "270099d227f7aa9b5ff2d6f4dd1b7244"

    private val client = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    override suspend fun search(cityName: String): SearchResponse {
        val resp = client.get("https://api.openweathermap.org/geo/1.0/direct"){
            parameter("q",cityName)
            parameter("limit",100)
            parameter("lang","es")
            parameter("appid",apiKey)
        }
        if(resp.status == HttpStatusCode.OK){
            val cities = resp.body<SearchResponse>()
            return cities
        } else {
            throw Exception()
        }
    }

    override suspend fun getWeather(coord: Coord): WeatherResponse {
        val resp = client.get("https://api.openweathermap.org/data/2.5/weather"){
            parameter("lat",coord.lat)
            parameter("lon",coord.lon)
            parameter("lang","es")
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (resp.status == HttpStatusCode.OK){
            val weather = resp.body<WeatherResponse>()
            return weather
        } else {
            throw Exception()
        }
    }

    override suspend fun getForecast(coord: Coord): ForecastResponse {
        val resp = client.get("https://api.openweathermap.org/data/2.5/forecast"){
            parameter("lat",coord.lat)
            parameter("lon",coord.lon)
            parameter("lang","es")
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (resp.status == HttpStatusCode.OK){
            val forecast = resp.body<ForecastResponse>()
            return forecast
        } else {
            throw Exception()
        }
    }

}