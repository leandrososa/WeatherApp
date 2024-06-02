package com.leandrososa.weatherapp.view.cities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.leandrososa.weatherapp.components.CityList
import com.leandrososa.weatherapp.view.weather.WeatherViewModel

@Composable
fun Cities(navController: NavHostController, modifier: Modifier = Modifier) {
    val vm: CitiesViewModel = viewModel()
    Column(modifier = modifier.padding(16.dp)) {
        Row{
            TextField(
              value = "",
              onValueChange = {},
              modifier = Modifier,
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
            IconButton(onClick = { }, ) {
                Icon(
                    Icons.Rounded.Place,
                    contentDescription = "Usar geo"
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CityList(vm.cities)
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
