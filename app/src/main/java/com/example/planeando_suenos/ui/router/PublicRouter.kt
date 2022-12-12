package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.screens.login.LoginModel
import com.example.planeando_suenos.ui.screens.login.LoginScreen

@Composable
fun PublicRouter(navController: NavHostController, mainModel: MainModel = viewModel()) {

    NavHost(
        navController = navController,
        startDestination =  PublicRouterDir.LOGIN.route
    ) {

            composable(PublicRouterDir.LOGIN.route) {
                val model = hiltViewModel<LoginModel>()
                LoginScreen(
                    model = model,
                    mainModel = mainModel,
                    navController = navController
                )
            }
    }

}