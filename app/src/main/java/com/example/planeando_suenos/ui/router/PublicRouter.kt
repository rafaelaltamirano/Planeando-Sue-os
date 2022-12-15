package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.router.PublicRouterDir.*
import com.example.planeando_suenos.ui.screens.landing.LandingModel
import com.example.planeando_suenos.ui.screens.landing.LandingScreen
import com.example.planeando_suenos.ui.screens.landing.LandingState
import com.example.planeando_suenos.ui.screens.login.LoginModel
import com.example.planeando_suenos.ui.screens.login.LoginScreen
import com.example.planeando_suenos.ui.screens.register.RegisterModel
import com.example.planeando_suenos.ui.screens.register.RegisterScreen

@Composable
fun PublicRouter(navController: NavHostController, mainModel: MainModel = viewModel()) {

    val loginModel = hiltViewModel<LoginModel>()
    val registerModel = hiltViewModel<RegisterModel>()
    val landingModel = hiltViewModel<LandingModel>()

    NavHost(
        navController = navController,
        startDestination = LANDING.route
    ) {

        composable(LOGIN.route) {
            LoginScreen(
                model = loginModel,
                mainModel = mainModel,
                navController = navController
            )
        }

        composable(REGISTER.route) {

            RegisterScreen(
                model = registerModel,
                mainModel = mainModel,
                navController = navController
            )
        }

        composable(LANDING.route) {

            LandingScreen(
                model = landingModel,
                mainModel = mainModel,
                navController = navController
            )
        }
    }

}