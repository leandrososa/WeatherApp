package com.leandrososa.weatherapp.router

interface IRouter {
    fun navigate(route: Route)
}

sealed class Route(val id: String) {
    data object Cities: Route("cities")
    data class Weather(
        var lat: Double = 0.0,
        var lon: Double = 0.0
    ): Route("weather")
}