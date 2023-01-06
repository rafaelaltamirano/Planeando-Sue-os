package com.example.planeando_suenos.ui.screens.home.step3

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.Status
import com.example.planeando_suenos.ui.components.StepsProgressBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.step2.Step2Step
import com.example.planeando_suenos.ui.screens.home.step3.creditAmount.CreditAmountStep
import com.example.planeando_suenos.ui.screens.home.step3.creditQuestion.CreditQuestionStep
import com.example.planeando_suenos.ui.screens.home.step3.frequencyExpenses.FrequencyExpensesStep
import kotlinx.coroutines.launch

@Composable
fun YourExpensesScreen(
    model: YourExpensesIncomeViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = true) {
        if (state.step == Step3Step.FREQUENCY_EXPENSES) navController.popBackStack()
        else model.prevStep()
    }

    homeModel.state.income?.let {
        LaunchedEffect(Unit) {
            model.setIncome(homeModel.state.income)
        }
    }

    mainModel.state.dreamId?.let {
        LaunchedEffect(Unit) {
            model.setDreamId(mainModel.state.dreamId!!)
        }
    }

    if (model.state.checked) {
        homeModel.setCheckedStep3(true)
        LaunchedEffect(Unit) {
            navController.navigate(UserRouterDir.HOME.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }
    }

    model.status?.also {
        val (status, _) = it
        when (status) {
            Status.NETWORK_ERROR -> mainModel.setNetworkErrorStatus(it)
            Status.ERROR -> mainModel.setErrorStatus(it)
            Status.INTERNET_CONNECTION_ERROR -> mainModel.setInternetConnectionError(it)
            else -> {}
        }
        model.clearStatus()
    }

    if (model.state.checked) {
        homeModel.setCheckedStep3(true)
    }

    Scaffold(
        topBar = {
            StepsProgressBar(
                numberOfSteps = Step3Step.values().size - 1,
                currentStep = state.step.step,
                onBackPress = {
                    if (state.step == Step3Step.FREQUENCY_EXPENSES) navController.popBackStack()
                    else model.prevStep()
                }
            )
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {
            Step3Step.FREQUENCY_EXPENSES -> FrequencyExpensesStep(
                model = model,
                onNext = model::nextStep,
            )
            Step3Step.CREDIT_QUESTION -> CreditQuestionStep(
                onNext = model::nextStep,
                model = model,
            )
            Step3Step.CREDIT_AMOUNT -> CreditAmountStep(
                model = model,
                onNext = {
                    coroutineScope.launch { model.updateDream(model.getDreamObject()) }
                },
            )
        }
    }
}