package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.ui.components.BottomSheetDreamOptions
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.calendar.CalendarStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.dreamsList.DreamListStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers.ReviewNumbersStep
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


@Composable
fun EmulateDreamsScreen(
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state
//    val dreamId = mainModel.state.dreamId!!
    val dreamId = "63bc8479d97880ed1b56f034"
    val coroutineScope = rememberCoroutineScope()
    //TODO: CHANGE
//    val dreamId = state.dreamId!!

    dreamId.let {
        model.setDreamId(it)
    }

    if (model.state.checked) {

        homeModel.setCheckedEmulateDreamStep(true)
    }

    BackHandler(enabled = true) {
        if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        backgroundColor = Color.White,
    ) {
        BottomSheetDreamOptions(
            onNext = {
                model.setPriority(it)
                if (state.cancelOnNext) {
                    coroutineScope.launch {
                        model.getDream(dreamId, state.prioritySelected ?: "equal")
                        model.setStep(EmulateDreamsStep.LIST)
                    }

                } else model.nextStep()
            },
            model = model,
            mainModel = mainModel
        ) { expandBottomSheetFunction ->

            when (state.step) {

                EmulateDreamsStep.REVIEW_NUMBERS -> ReviewNumbersStep(
                    onNext = model::nextStep,
                    model = model,
                    mainModel = mainModel,
                    onShowBottomSheet = expandBottomSheetFunction,
                    navController = navController
                )

                EmulateDreamsStep.LIST -> DreamListStep(
                    onNext = { model.updateDreamAndGetCalendar() },
                    onSubmit = {
                        navController.navigate(UserRouterDir.HOME.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    },
                    model = model,
                    mainModel = mainModel,
                    onShowBottomSheet = expandBottomSheetFunction,

                    )
                EmulateDreamsStep.CALENDAR -> CalendarStep(
                    model,
                    mainModel.state.dreamId.orEmpty(),
                    onSubmit = {
                        navController.navigate(UserRouterDir.HOME.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    },
                    onBack = model::prevStep
                )
            }
        }
    }
}




