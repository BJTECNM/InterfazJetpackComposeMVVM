package com.laraknife.interfazjetpackcompose1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laraknife.interfazjetpackcompose1.viewmodel.data.ViewModel
import com.laraknife.interfazjetpackcompose1.viewmodel.ui.Home
import com.laraknife.interfazjetpackcompose1.viewmodel.ui.Login
import com.laraknife.interfazjetpackcompose1.viewmodel.ui.Register

@Composable
fun AppNavigation(viewModel: ViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.Login.route) {
        composable(route = AppScreens.Login.route) {
            Login(navController, viewModel)
        }

        composable(route = AppScreens.Register.route) {
            Register(navController, viewModel)
        }

        composable(route = AppScreens.Home.route){
            Home(navController, viewModel)
        }
    }
}