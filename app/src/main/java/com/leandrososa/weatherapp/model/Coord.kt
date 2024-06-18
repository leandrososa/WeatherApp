package com.leandrososa.weatherapp.model

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat") val lat: Float,
    @SerializedName("lon") val lon: Float
)

