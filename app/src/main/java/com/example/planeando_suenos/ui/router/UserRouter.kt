package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir.*
import com.example.planeando_suenos.ui.screens.home.HomeScreen
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.step1.DreamsAndAspirationsScreen
import com.example.planeando_suenos.ui.screens.step1.DreamsAndAspirationsViewModel
import com.example.planeando_suenos.ui.screens.step2.ApproximateIncomesScreen
import com.example.planeando_suenos.ui.screens.step2.ApproximateIncomesViewModel
import com.example.planeando_suenos.ui.screens.step3.YourExpensesIncomeViewModel
import com.example.planeando_suenos.ui.screens.step3.YourExpensesScreen


@Composable
fun UserRouter(navController: NavHostController, mainModel: MainViewModel = viewModel()) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val dreamsAndAspirationsViewModel = hiltViewModel<DreamsAndAspirationsViewModel>()
    val approximateIncomesViewModel = hiltViewModel<ApproximateIncomesViewModel>()
    val yourExpensesIncomeViewModel = hiltViewModel<YourExpensesIncomeViewModel>()

    NavHost(navController = navController, startDestination = HOME.route) {
        composable(HOME.route) {
            HomeScreen(homeViewModel, navController)
        }
        composable(STEP_1.route) {
            DreamsAndAspirationsScreen(dreamsAndAspirationsViewModel, mainModel, navController)
        }
        composable(STEP_2.route) {
            ApproximateIncomesScreen(approximateIncomesViewModel, mainModel, navController)
        }
        composable(STEP_3.route) {
            YourExpensesScreen(yourExpensesIncomeViewModel, mainModel, navController)
        }
    }
}
