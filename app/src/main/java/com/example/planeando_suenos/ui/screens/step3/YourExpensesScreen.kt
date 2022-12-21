package com.example.planeando_suenos.ui.screens.step3

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.step3.expensesConfirmation.ExpensesConfirmationStep
import com.example.planeando_suenos.ui.screens.step3.expensesData.ExpensesDataStep
import com.example.planeando_suenos.ui.screens.step3.expensesResume.ExpensesResumeStep

@Composable
fun YourExpensesScreen (
    model: YourExpensesIncomeViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step3Step.EXPENSE_DATA) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {},
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            Step3Step.EXPENSE_DATA -> ExpensesDataStep(
                onNext = model::nextStep,
            )
            Step3Step.EXPENSE_RESUME -> ExpensesResumeStep(
                onNext = model::nextStep,
            )
            Step3Step.CONFIRMATION -> ExpensesConfirmationStep(
                onNext =  { navController.navigate(UserRouterDir.HOME.route) },
            )
        }
    }
}