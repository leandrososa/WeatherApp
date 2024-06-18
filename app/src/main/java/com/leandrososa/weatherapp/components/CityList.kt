package com.leandrososa.weatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leandrososa.weatherapp.model.Place
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CityList(places: List<Place>, onPlaceClick: (Place) -> Unit) {
    Column {
        for (place in places) {
            CityItem(place, onPlaceClick)
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
                Place(
                    name = "Buenos Aires",
                    lat = -34.61,
                    lon = -58.38,
                    country = "AR",
                    state = "Buenos Aires"
                ),
                Place(
                    name = "Bahía Blanca",
                    lat = -38.72,
                    lon = -62.27,
                    country = "AR",
                    state = "Buenos Aires"
                )
            ),
            onPlaceClick = {}
        )
    }
}
