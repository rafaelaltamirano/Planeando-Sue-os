package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.BottomSheetDreamOptions
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.dreamsList.DreamListStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers.ReviewNumbersStep


@Composable
fun EmulateDreamsScreen(
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state


    if (model.state.checked) {
        homeModel.setCheckedEmulateDreamStep(true)
    }

    BackHandler(enabled = true) {
        if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {

        },
        backgroundColor = Color.White,
    ) {

        BottomSheetDreamOptions(
            onNext = model::nextStep,
            model = model,
            mainModel = mainModel
        ) {

            when (state.step) {

                EmulateDreamsStep.REVIEW_NUMBERS -> ReviewNumbersStep(
                        onNext = model::nextStep,
                        model = model,
                        mainModel = mainModel,
                        onShowBottomSheet = it
                )

                EmulateDreamsStep . LIST -> DreamListStep(
                    onNext = model::nextStep,
                    model = model,
                    mainModel = mainModel

                )
                EmulateDreamsStep.CALENDAR -> {}
                EmulateDreamsStep.CONFIRMATION -> {}
            }
            EmulateDreamsStep.CALENDAR -> CalendarStep(
                onSavePlan = model::nextStep,
                onBack = model::prevStep
            )
            EmulateDreamsStep.CONFIRMATION -> {}
        }
    }
}




