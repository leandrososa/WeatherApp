package com.leandrososa.weatherapp.router

import androidx.navigation.NavHostController

class Router(val navHostController: NavHostController) : IRouter {
    override fun navigate(route: Route) {
        navHostController.navigate(route.id)
    }
}