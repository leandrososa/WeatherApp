package com.leandrososa.weatherapp.view.cities

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.leandrososa.weatherapp.repository.MockRepository
import com.leandrososa.weatherapp.router.Router

@Composable
fun CitiesPage(
    navHostController: NavHostController
){
    val viewModel: CitiesViewModel = viewModel(
        factory = CitiesViewModelFactory(
            repo = MockRepository(),
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