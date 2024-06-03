package com.leandrososa.weatherapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leandrososa.weatherapp.model.Place
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CityItem(place: Place) {
    val vm: CityListViewModel = viewModel()

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
                    text = place.name,
                    fontSize = 18.sp
                )
                Text(place.state + ", " + place.country, fontSize = 14.sp)
            }
            Column(){
                Text(
                    text = place.country,
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
            Place(
                name = "Buenos Aires",
                lat = -34.61,
                lon = -58.38,
                country = "AR",
                state = "Buenos Aires"
            )
        )
    }
}