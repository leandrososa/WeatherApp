package com.leandrososa.weatherapp.view.weather.forecast

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.leandrososa.weatherapp.model.Coord
import com.leandrososa.weatherapp.repository.IRepository
import kotlinx.coroutines.launch

class ForecastViewModel(
    val repo: IRepository,
    val lat: Float,
    val lon: Float
): ViewModel() {
    var uiState by mutableStateOf<ForecastState>(ForecastState.Loading)

    fun execute(intent: ForecastIntent){
        when(intent){
            is ForecastIntent.GetForecast -> updateForecast(intent.coord)
        }
    }

    private fun updateForecast(coord: Coord){
        uiState = ForecastState.Loading
        viewModelScope.launch {
            try {
                val forecast = repo.getForecast(coord)
                uiState = ForecastState.Success(forecast)
            } catch (exception: Exception) {
                uiState = ForecastState.Error
            }
        }
    }
}

class ForecastViewModelFactory(
    private val repo: IRepository,
    private val lat: Float,
    private val lon: Float
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ForecastViewModel::class.java)) {
            return ForecastViewModel(repo, lat, lon) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}