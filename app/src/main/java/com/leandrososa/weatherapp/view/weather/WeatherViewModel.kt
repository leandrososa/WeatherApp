package com.leandrososa.weatherapp.view.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.repository.IRepository
import com.leandrososa.weatherapp.router.IRouter
import com.leandrososa.weatherapp.router.Route
import kotlinx.coroutines.launch

class WeatherViewModel(
    val repo: IRepository,
    val router: IRouter,
    val lat : Float,
    val lon : Float
): ViewModel()
     {


    var uiState by mutableStateOf<WeatherState>(WeatherState.Loading)
    fun execute(intent: WeatherIntent) {
        when(intent) {
            is WeatherIntent.GetWeather -> updateWeather(intent.coord)
            is WeatherIntent.ShareWeather -> shareWeather()
            is WeatherIntent.ReturnToCities -> returnToCities()
        }
    }

    private fun updateWeather(coord: Coord) {
        uiState = WeatherState.Loading
        viewModelScope.launch {
            try {
                val weather = repo.getWeather(coord)
                uiState = WeatherState.Success(weather)
            } catch (exception: Exception) {
                uiState = WeatherState.Error
            }

        }
    }

     private fun shareWeather() {
         //TODO: Implement
     }

     private fun returnToCities() {
         router.navigate(Route.Cities)
     }
}

class WeatherViewModelFactory(
    private val repo: IRepository,
    private val router: IRouter,
    private val lat: Float,
    private val lon: Float
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(repo, router, lat, lon) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
