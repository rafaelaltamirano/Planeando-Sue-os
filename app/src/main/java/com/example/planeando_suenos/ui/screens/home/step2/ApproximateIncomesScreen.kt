package com.example.planeando_suenos.ui.screens.home.step2

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.Expenses
import com.example.planeando_suenos.domain.body.smartShopping.Income
import com.example.planeando_suenos.domain.body.smartShopping.UserFinance
import com.example.planeando_suenos.ui.Status
import com.example.planeando_suenos.ui.components.StepsProgressBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.step2.extraIncomes.FrequencyIncomesStep
import com.example.planeando_suenos.ui.screens.home.step2.frecuencyIncomes.ExtraIncomesStep
import com.example.planeando_suenos.ui.screens.home.step2.incomesData.IncomeDataStep
import kotlinx.coroutines.launch


@Composable
fun ApproximateIncomesScreen(
    model: ApproximateIncomesViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = true) {
        if (state.step == Step2Step.INCOME_DATA) navController.popBackStack()
        else model.prevStep()
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
        homeModel.setCheckedStep2(true)
        homeModel.setIncome(model.getIncomeObject())
        model.setStep(Step2Step.INCOME_DATA)
        model.setChecked(false)
        LaunchedEffect(Unit) {
            navController.navigate(UserRouterDir.HOME.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }
    }

    mainModel.state.dreamId?.let {
        LaunchedEffect(Unit) {
            model.setDreamId(mainModel.state.dreamId!!)
        }
    }

    Scaffold(
        topBar = {
            StepsProgressBar(
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
                onNext = {
//                    coroutineScope.launch { model.getDream(mainModel.state.dreamId!!) }
                    model.nextStep()
                },
                model = model,
                mainModel = mainModel
            )
            Step2Step.FREQUENCY_INCOMES -> FrequencyIncomesStep(
                onNext = model::nextStep,
                model = model
            )
            Step2Step.EXTRA_INCOMES -> ExtraIncomesStep(
                onSubmit = { coroutineScope.launch { model.updateDream(model.getDreamObject()) } },
                model = model
            )
        }
    }
}

