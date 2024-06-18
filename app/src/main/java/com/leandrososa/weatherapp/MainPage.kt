package com.leandrososa.weatherapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.leandrososa.weatherapp.router.Route
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme
import com.leandrososa.weatherapp.view.cities.CitiesPage
import com.leandrososa.weatherapp.view.weather.WeatherPage

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = { MainTopAppBar() }

    ) {
        MainNavHost(
            modifier = Modifier.padding(it),
            navHostController = navHostController
        )
    }
}



@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController : NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Route.Cities.id
    ) {
        composable(Route.Cities.id) {
            CitiesPage(
                navHostController = navHostController
            )
        }
        composable(
            route = "weather?lat={lat}&lon={lon}",
            arguments =  listOf(
                navArgument("lat") { defaultValue = 0.0 },
                navArgument("lon") { defaultValue = 0.0 }
            )
        ) {
            //Weather(navHostController)
            val lat = it.arguments?.getFloat("lat") ?: 0.0f
                val lon = it.arguments?.getFloat("lon") ?: 0.0f
                WeatherPage(navHostController, lat = lat, lon = lon)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(){
    TopAppBar(
        title = {
            Text(text = "Clima hoy")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    WeatherAppTheme {
        MainPage()
    }
}