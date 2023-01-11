package com.example.planeando_suenos.ui.screens.home.step1

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
import com.example.planeando_suenos.ui.screens.home.step1.dreamPlan.DreamPlanStep
import com.example.planeando_suenos.ui.screens.home.step1.dreamsGrid.DreamsGridStep
import kotlinx.coroutines.launch

@Composable
fun DreamsAndAspirationsScreen(
    model: DreamsAndAspirationsViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state
    val coroutineScope = rememberCoroutineScope()

    if (model.state.checked) {
        homeModel.setCheckedStep1(true)
        mainModel.setDreamId(model.state.dreamId!!)
        LaunchedEffect(Unit){
            navController.navigate(UserRouterDir.HOME.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(Unit){
        model.getDreamType()
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

    BackHandler(enabled = true) {
        if (state.step == Step1Step.DREAMS_GRID) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {
            StepsProgressBar(
                numberOfSteps = Step1Step.values().size - 1,
                currentStep = state.step.step,
                onBackPress = {
                    if (state.step == Step1Step.DREAMS_GRID) navController.popBackStack()
                    else model.prevStep()
                }
            )
        },
        backgroundColor = Color.White,
    ) {
        //Topbar is here
        when (state.step) {

            Step1Step.DREAMS_GRID -> DreamsGridStep(
                onNext = model::nextStep,
                model = model
            )

            Step1Step.DREAM_PLAN -> DreamPlanStep(
                model = model
            ) {
                coroutineScope.launch {
                    model.submitDream()


                }

            }
        }
    }
}




