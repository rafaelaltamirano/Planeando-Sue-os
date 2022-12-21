package com.example.planeando_suenos.ui.screens.step1

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.step1.dreamsData.DreamsDataStep
import com.example.planeando_suenos.ui.screens.step1.dreamsType.DreamsTypeStep

@Composable
fun DreamsAndAspirationsScreen(
    model: DreamsAndAspirationsViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step1Step.DREAM_DATA) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {},
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            Step1Step.DREAM_TYPE -> DreamsTypeStep(
                onNext = model::nextStep
            )
            Step1Step.DREAM_DATA -> DreamsDataStep(

                onNext = { navController.navigate(UserRouterDir.HOME.route) },
            )

        }
    }
}




