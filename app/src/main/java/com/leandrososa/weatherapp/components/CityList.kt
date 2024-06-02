package com.leandrososa.weatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leandrososa.weatherapp.model.City
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CityList(cities: List<City>) {
    Column {
        for (city in cities) {
            CityItem(city)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CityListPreview() {
    WeatherAppTheme {
        CityList(
            listOf(
                City(
                    name = "Buenos Aires",
                    weatherDescription = "Cloudy",
                    currentTemperature = 11.7,
                    lat = null,
                    lon = null,
                    weatherIcon = null,
                    dayTemps = null
                ),
                City(
                    name = "Bahía Blanca",
                    weatherDescription = "Sunny",
                    currentTemperature = 18.3,
                    lat = null,
                    lon = null,
                    weatherIcon = null,
                    dayTemps = null
                )
            )
        )
    }
}
