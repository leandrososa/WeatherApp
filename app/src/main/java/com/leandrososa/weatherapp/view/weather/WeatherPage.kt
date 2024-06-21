package com.leandrososa.weatherapp.view.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.leandrososa.weatherapp.repository.MockRepository
import com.leandrososa.weatherapp.router.Router
import com.leandrososa.weatherapp.view.weather.forecast.Forecast
import com.leandrososa.weatherapp.view.weather.forecast.ForecastViewModel
import com.leandrososa.weatherapp.view.weather.forecast.ForecastViewModelFactory

@Composable
fun WeatherPage(
    navHostController: NavHostController,
    lat: Float,
    lon: Float
){
    val weatherVm: WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(
            repo = MockRepository(),
            router = Router(navHostController),
            lat = lat,
            lon = lon
        )
    )

    val forecastVm: ForecastViewModel = viewModel(
        factory = ForecastViewModelFactory(
            repo = MockRepository(),
            lat = lat,
            lon = lon
        )
    )
    Column{
        Weather(
            state = weatherVm.uiState,
            onAction = { intent ->
                weatherVm.execute(intent)
            }
        )
        Forecast(
            state = forecastVm.uiState,
            onAction = { intent ->
                forecastVm.execute(intent)
            }
        )
    }
}