package com.leandrososa.weatherapp.view.cities

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leandrososa.weatherapp.components.CityList

@Composable
fun Cities(
    modifier: Modifier = Modifier,
    state: CitiesState,
    onAction: (CitiesIntent) -> Unit
) {
    val vm: CitiesViewModel = viewModel()
    Column(modifier = modifier.padding(16.dp)) {
        Row{
            TextField(
              value = vm.searchText.value,
              onValueChange = { newText -> vm.searchText.value = newText},
              modifier = Modifier.weight(1f),
              keyboardOptions = KeyboardOptions(
                  keyboardType = KeyboardType.Text,
                  imeAction = ImeAction.Done
              ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onAction(CitiesIntent.Search(vm.searchText.value))
                    }
                ),
              placeholder = { Text("Buscar ciudad") },
              leadingIcon = {
                  IconButton(onClick = { }) {
                      Icon(
                          Icons.Rounded.Search,
                          contentDescription = "Buscar ciudad"
                      )
                  }
              }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                modifier =
                    Modifier
                        .height(56.dp),
                onClick = {}
            ) {
                Icon(
                    Icons.Rounded.Place,
                    contentDescription = "Usar geo"
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        when(state) {
            CitiesState.Loading -> {
                Text(
                    text = "Cargando",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            is CitiesState.DefaultValues -> CityList(state.places) { place ->
                onAction(CitiesIntent.GoToWeather(place.lat, place.lon))
                Log.d("Cities", "Nav to: ${place.name} (${place.lat}, ${place.lon})")
            }
            is CitiesState.Success -> CityList(state.places) { place ->
                onAction(CitiesIntent.GoToWeather(place.lat, place.lon))
                Log.d("Cities", "Nav to: ${place.name} (${place.lat}, ${place.lon})")
            }
            CitiesState.Empty -> Text(
                text = "No hay resultados",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
}

/*
@Preview(showBackground = true)
@Composable
fun CitiesPreview() {
    WeatherAppTheme {
        Cities()
    }
}*/
