package com.example.planeando_suenos.ui.screens.step1

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.step1.dreamsGrid.DreamsGridStep
import com.example.planeando_suenos.ui.screens.step1.dreamPlan.DreamPlanStep

@Composable
fun DreamsAndAspirationsScreen(
    model: DreamsAndAspirationsViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step1Step.DREAM_PLAN) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {},
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            Step1Step.DREAMS_GRID -> DreamsGridStep(

                onNext = { navController.navigate(UserRouterDir.HOME.route) },
            )
            Step1Step.DREAM_PLAN -> DreamPlanStep(
                onNext = model::nextStep
            )

        }
    }
}




