package com.leandrososa.weatherapp.router

interface IRouter {
    fun navigate(route: Route)
}

sealed class Route(val id: String) {
    data object Cities: Route("cities")
    data class Weather(
        var lat: Float = 0.0f,
        var lon: Float = 0.0f
    ): Route("weather")
}