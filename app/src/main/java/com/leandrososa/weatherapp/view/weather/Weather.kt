package com.leandrososa.weatherapp.view.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun Weather(
    navController: NavHostController,
    modifier: Modifier = Modifier
    ) {

    val vm: WeatherViewModel = viewModel()

    Column(modifier = modifier) {
        Text(
            text = vm.city.value,
            modifier = modifier
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherAppTheme {
        Weather()
    }
}*/
