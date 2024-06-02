package com.leandrososa.weatherapp.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    val places: List<Place>
)

data class Place (
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String,
    @SerializedName("local_names") val localNames: LocalNames? = null
)

data class LocalNames (
    val ascii: String,
    val featureName: String
)