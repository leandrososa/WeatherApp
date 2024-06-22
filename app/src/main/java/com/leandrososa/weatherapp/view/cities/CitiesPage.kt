package com.leandrososa.weatherapp.view.cities

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.leandrososa.weatherapp.repository.APIRepository
import com.leandrososa.weatherapp.router.Router

@Composable
fun CitiesPage(
    navHostController: NavHostController
){
    val viewModel: CitiesViewModel = viewModel(
        factory = CitiesViewModelFactory(
            repo = APIRepository(),
            router = Router(navHostController)
        )
    )
    Cities(
        state = viewModel.uiState,
        onAction = { intent ->
            viewModel.execute(intent)
        }
    )
}