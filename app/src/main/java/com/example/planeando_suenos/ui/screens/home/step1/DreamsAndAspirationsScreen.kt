package com.example.planeando_suenos.ui.screens.home.step1

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.StepsProgressBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.step1.dreamsGrid.DreamsGridStep
import com.example.planeando_suenos.ui.screens.home.step1.dreamPlan.DreamPlanStep
import com.example.planeando_suenos.ui.screens.home.step2.Step2Step

@Composable
fun DreamsAndAspirationsScreen(
    model: DreamsAndAspirationsViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state


    if (model.state.checked) {
        homeModel.setCheckedStep1(true)
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
            else model.prevStep() }
        )
        },
        backgroundColor = Color.White,
    ) {
        //Topbar is here
        when (state.step) {

            Step1Step.DREAMS_GRID -> DreamsGridStep(
                onNext = model::nextStep,
            )

            Step1Step.DREAM_PLAN -> DreamPlanStep(
                onFinish = {
                    model.setChecked(true)
                    navController.navigate(UserRouterDir.HOME.route)
                }
            )

        }
    }
}




