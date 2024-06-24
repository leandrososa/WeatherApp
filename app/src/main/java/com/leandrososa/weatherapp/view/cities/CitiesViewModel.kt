package com.leandrososa.weatherapp.view.cities

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.LocationServices
import com.leandrososa.weatherapp.model.Place
import com.leandrososa.weatherapp.repository.IRepository
import com.leandrososa.weatherapp.router.IRouter
import com.leandrososa.weatherapp.router.Route
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine

class CitiesViewModel(val repo: IRepository, val router: IRouter): ViewModel() {
    var searchText =  mutableStateOf("")
    var places = listOf(
        Place(
            name = "Buenos Aires",
            lat = -34.61f,
            lon = -58.38f,
            country = "AR",
            state = "Buenos Aires"
        ),
        Place(
            name = "Bahía Blanca",
            lat = -38.72f,
            lon = -62.27f,
            country = "AR",
            state = "Buenos Aires"
        ),
        Place(
            name = "Córdoba",
            lat = -31.42f,
            lon = -64.18f,
            country = "AR",
            state = "Córdoba"
        ),
        Place(
            name = "Rosario",
            lat = -32.95f,
            lon = -60.64f,
            country = "AR",
            state = "Santa Fe"
        ),
        Place(
            name = "Misiones",
            lat = -27.37f,
            lon = -55.90f,
            country = "AR",
            state = "Misiones"
        ),
        Place(
            name = "La Plata",
            lat = -34.92f,
            lon = -57.95f,
            country = "AR",
            state = "Buenos Aires"
        )
    )
    var location  = mutableStateOf<Pair<Double, Double>?>(null);
    var hasPermission = mutableStateOf(false)
    var uiState by mutableStateOf<CitiesState>(CitiesState.DefaultValues(places))

    fun execute(intent: CitiesIntent){
        when(intent){
            is CitiesIntent.UseGeo -> useGeo(intent.context)
            is CitiesIntent.Search -> search(intent.query)
            is CitiesIntent.GoToWeather -> goToWeather(intent.lat, intent.lon)
        }
    }

    private fun useGeo(context: Context){
        viewModelScope.launch {
            location.value = getCurrentLocation(context)
            goToWeather(location.value!!.first.toFloat(), location.value!!.second.toFloat())
        }
    }

    private fun search(query: String){
        uiState = CitiesState.Loading
        Log.d("Cities", "Loading")
        viewModelScope.launch {
            try {
                val searchResponse = repo.search(query)
                if (searchResponse.places.isEmpty()) {
                    uiState = CitiesState.Empty
                } else {
                    uiState = CitiesState.Success(searchResponse.places)
                }
            } catch(ex: Exception){
                uiState = CitiesState.DefaultValues(places)
                //todo: show error on snack bar
            }

        }
    }

    private fun goToWeather(lat: Float, lon: Float){
        router.navigate(Route.Weather(lat, lon))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @SuppressLint("MissingPermission")
    private suspend fun getCurrentLocation(context: Context): Pair<Double, Double>? {
        //todo: show failure error on snack bar
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        return suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        continuation.resume(
                            Pair(location.latitude, location.longitude),
                            onCancellation = {  }
                        )
                    } else {
                        continuation.resume(
                            null,
                            onCancellation = {  }
                        )
                    }
                }
                .addOnFailureListener {
                    continuation.resume(
                        null,
                        onCancellation = {  }
                    )
                }
        }
    }
}

class CitiesViewModelFactory(
    private val repo: IRepository,
    private val router: IRouter
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitiesViewModel::class.java)) {
            return CitiesViewModel(repo, router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}