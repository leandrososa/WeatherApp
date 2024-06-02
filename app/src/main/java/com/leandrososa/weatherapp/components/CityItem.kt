package com.leandrososa.weatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leandrososa.weatherapp.MainPage
import com.leandrososa.weatherapp.model.City
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CityItem(city: City) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = city.name,
                    fontSize = 18.sp
                )
                Text(city.weatherDescription)
            }
            Column(){
                Text(
                    text = "${city.currentTemperature}º",
                    fontSize = 24.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(1f)
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityItemPreview() {
    WeatherAppTheme {
        CityItem(
            City(
                name = "Buenos Aires",
                weatherDescription = "Cloudy",
                currentTemperature = 11.1,
                lat = null,
                lon = null,
                weatherIcon = null,
                dayTemps = null
            )
        )
    }
}