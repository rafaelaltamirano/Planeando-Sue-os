package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir.*
import com.example.planeando_suenos.ui.screens.landing.LandingViewModel
import com.example.planeando_suenos.ui.screens.landing.LandingScreen
import com.example.planeando_suenos.ui.screens.login.LoginViewModel
import com.example.planeando_suenos.ui.screens.login.LoginScreen
import com.example.planeando_suenos.ui.screens.register.RegisterViewModel
import com.example.planeando_suenos.ui.screens.register.RegisterScreen
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordScreen
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordViewModel

@Composable
fun PublicRouter(navController: NavHostController, mainModel: MainViewModel = viewModel()) {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val registerViewModel = hiltViewModel<RegisterViewModel>()
    val landingViewModel = hiltViewModel<LandingViewModel>()
    val restorePasswordViewModel = hiltViewModel<RestorePasswordViewModel>()


    NavHost(
        navController = navController,
        startDestination = LANDING.route
    ) {

        composable(LOGIN.route) {
            LoginScreen(
                model = loginViewModel,
                mainModel = mainModel,
                navController = navController
            )
        }

        composable(REGISTER.route) {

            RegisterScreen(
                model = registerViewModel,
                mainModel = mainModel,
                navController = navController
            )
        }

        composable(LANDING.route) {
            LandingScreen(
                model = landingViewModel,
                mainModel = mainModel,
                navController = navController
            )
        }

        composable(RESTORE_PASS.route) {
            RestorePasswordScreen(
                model = restorePasswordViewModel,
                mainModel = mainModel,
                navController = navController
            )
        }
    }

}