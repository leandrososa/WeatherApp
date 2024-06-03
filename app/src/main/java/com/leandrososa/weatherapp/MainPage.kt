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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leandrososa.weatherapp.ui.theme.WeatherAppTheme
import com.leandrososa.weatherapp.view.cities.Cities
import com.leandrososa.weatherapp.view.cities.CitiesViewModel
import com.leandrososa.weatherapp.view.weather.Weather

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
    val vm : CitiesViewModel = viewModel(factory = CitiesViewModel.factory)

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "cities"
    ) {
        composable("cities") {
            Cities(
                navController = navHostController,
                modifier = modifier,
                state = vm.uiState,
                onAction = {
                    vm.execute(it)
                }
            )
        }
        composable("weather") {
            Weather(navHostController)
        }
        /*composable(
            route = "home/{username}",
            arguments = listOf(
                navArgument(name = "username") { type = NavType.StringType }
            )
        ){
            val username = it.arguments?.getString("username")
            HomePage(username)
        }*/
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