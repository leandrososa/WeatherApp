package com.leandrososa.weatherapp.view.weather

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.leandrososa.weatherapp.repository.MockRepository
import com.leandrososa.weatherapp.router.Router

@Composable
fun WeatherPage(
    navHostController: NavHostController,
    lat: Float,
    lon: Float
){
    val viewModel: WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(
            repo = MockRepository(),
            router = Router(navHostController),
            lat = lat,
            lon = lon
        )
    )
    Weather(
        state = viewModel.uiState,
        onAction = { intent ->
            viewModel.execute(intent)
        }
    )
}