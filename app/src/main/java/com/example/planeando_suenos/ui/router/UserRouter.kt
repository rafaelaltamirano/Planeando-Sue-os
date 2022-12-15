package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir.HOME
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.HomeScreen


@Composable
fun UserRouter(navController: NavHostController, mainModel: MainViewModel = viewModel()) {
    val homeViewModel = hiltViewModel<HomeViewModel>()

    NavHost(navController = navController, startDestination = HOME.route) {
        composable(HOME.route) {
            HomeScreen(homeViewModel, navController)
        }
    }

}