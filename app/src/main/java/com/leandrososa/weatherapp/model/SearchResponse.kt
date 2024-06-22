package com.leandrososa.weatherapp.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse (
    var places: List<Place>
)

@Serializable
data class Place (
    val name: String,
    @SerializedName("local_names") val localNames: Map<String, String>? = null,
    val lat: Float,
    val lon: Float,
    val country: String,
    val state: String? = ""
)

@Serializable
data class LocalNames (
    val ascii: String,
    val featureName: String
)