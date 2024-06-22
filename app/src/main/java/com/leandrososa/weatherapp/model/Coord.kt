package com.leandrososa.weatherapp.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    @SerializedName("lat") val lat: Float,
    @SerializedName("lon") val lon: Float
)

