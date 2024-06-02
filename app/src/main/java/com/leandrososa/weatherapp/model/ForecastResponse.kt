package com.leandrososa.weatherapp.model

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("cod") val cod: String,
    @SerializedName("message") val message: Int,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val list: List<DayWeather>,
    @SerializedName("city") val city: CityInfo
)

data class DayWeather(
    @SerializedName("dt") val dt: Long,
    @SerializedName("main") val main: WeatherMain,
    @SerializedName("weather") val weather: List<WeatherDesc>,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("sys") val sys: ForecastSys,
    @SerializedName("dt_txt") val dtTxt: String
)



data class ForecastSys(
    @SerializedName("pod") val pod: String
)

data class CityInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("coord") val coord: Coord,
    @SerializedName("country") val country: String,
    @SerializedName("population") val population: Int,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
)


