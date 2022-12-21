package com.example.planeando_suenos.ui.screens.step2

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.step2.confirmation.ConfirmationStep
import com.example.planeando_suenos.ui.screens.step2.extraIncomes.ExtraIncomesStep
import com.example.planeando_suenos.ui.screens.step2.incomeFrequency.IncomeFrequencyStep
import com.example.planeando_suenos.ui.screens.step2.incomesData.IncomeDataStep


@Composable
fun ApproximateIncomesScreen (
    model: ApproximateIncomesViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step2Step.INCOME_DATA) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {},
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            Step2Step.INCOME_DATA -> IncomeDataStep(
                onNext = model::nextStep,
            )
            Step2Step.EXTRA_INCOMES -> ExtraIncomesStep(
                onNext = model::nextStep,
            )
            Step2Step.INCOME_FREQUENCY -> IncomeFrequencyStep(
                onNext = model::nextStep,
            )
            Step2Step.CONFIRMATION -> ConfirmationStep(
                onNext =  { navController.navigate(UserRouterDir.HOME.route) },
            )
        }
    }
}

