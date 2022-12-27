package com.example.planeando_suenos.ui.screens.home.step2

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.StepsProgressBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.step2.extraIncomes.FrequencyIncomesStep
import com.example.planeando_suenos.ui.screens.home.step2.frecuencyIncomes.ExtraIncomesStep
import com.example.planeando_suenos.ui.screens.home.step2.incomesData.IncomeDataStep


@Composable
fun ApproximateIncomesScreen(
    model: ApproximateIncomesViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step2Step.INCOME_DATA) navController.popBackStack()
        else model.prevStep()
    }

    if (model.state.checked) {
        homeModel.setCheckedStep2(true)
    }

    Scaffold(
        topBar = {
            if (state.step != Step2Step.EXTRA_INCOMES) StepsProgressBar(
                numberOfSteps = Step2Step.values().size - 2,
                currentStep = state.step.step,
                onBackPress = {
                    if (state.step == Step2Step.INCOME_DATA) navController.popBackStack()
                    else model.prevStep()
                }
            )
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            Step2Step.INCOME_DATA -> IncomeDataStep(
                onNext = model::nextStep,
                model = model
            )
            Step2Step.FREQUENCY_INCOMES -> FrequencyIncomesStep(
                onNext = model::nextStep,
                model = model
            )
            Step2Step.EXTRA_INCOMES -> ExtraIncomesStep(
                onNext = {
                    model.setChecked(true)
                    navController.navigate(UserRouterDir.HOME.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            inclusive = true  }}
                },

                model = model
            )
        }
    }
}

