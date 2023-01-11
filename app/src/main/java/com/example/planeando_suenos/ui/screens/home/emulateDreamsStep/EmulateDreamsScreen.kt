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
import com.example.planeando_suenos.ui.components.TopBarClearWithBack
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.calendar.CalendarStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.confirmation.ConfirmationAndOfferCreditStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.dreamsList.DreamListStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers.ReviewNumbersStep
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.saveDream.SaveDreamStep
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
    val topBarTitle: String
    val bigFont: Boolean

    dreamId.let { model.setDreamId(it) }
    if (model.state.checked) homeModel.setCheckedEmulateDreamStep(true)

    BackHandler(enabled = true) {
        if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) navController.popBackStack()
        else model.prevStep()
    }

    when (state.step) {
        EmulateDreamsStep.REVIEW_NUMBERS -> {
            topBarTitle = "${mainModel.state.user?.firstName}, repasemos \nestas cuentas"
            bigFont = true
        }
        EmulateDreamsStep.LIST -> {
            topBarTitle = "Todos tus sueños al mismo tiempo"
            bigFont = false
        }
        EmulateDreamsStep.CALENDAR -> {
            topBarTitle = "Calendario de pago"
            bigFont = false
        }

        EmulateDreamsStep.SAVE_DREAM -> {
            topBarTitle = "Calendario de pago"
            bigFont = false
        }
        else -> {
            topBarTitle = ""
            bigFont = false
        }
    }

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
        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                if (state.step != EmulateDreamsStep.CONFIRMATION) {
                    TopBarClearWithBack(title = topBarTitle,
                        bigFont = bigFont,
                        onBackPress = {
                            if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) navController.popBackStack()
                            else model.prevStep()
                        })
                }
            }
        ) {

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
                        coroutineScope.launch {
                            model.updateDream(
                                DreamPlan(
                                    title = state.dreamWithUser?.title,
                                    endDate = state.dreamWithUser?.endDate,
                                    userFinance = state.dreamWithUser?.userFinance,
                                    dream = state.dreamWithUser?.dream,
                                    id = state.dreamWithUser?.id
                                )
                            )
                        }.invokeOnCompletion {
                            model.setStep(EmulateDreamsStep.SAVE_DREAM)
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
                        coroutineScope.launch {
                            model.updateDream(
                                DreamPlan(
                                    title = state.dreamWithUser?.title,
                                    endDate = state.dreamWithUser?.endDate,
                                    userFinance = state.dreamWithUser?.userFinance,
                                    dream = state.dreamWithUser?.dream,
                                    id = state.dreamWithUser?.id
                                )
                            )
                        }.invokeOnCompletion {
                            model.nextStep()
                        }
                    },
                    onBack = model::prevStep
                )
                EmulateDreamsStep.SAVE_DREAM -> {
                    SaveDreamStep(
                        model = model,
                        onNext = {
                            coroutineScope.launch {
                                model.updateDream(
                                    DreamPlan(
                                        title = state.dreamName,
                                        endDate = state.dreamWithUser?.endDate,
                                        userFinance = state.dreamWithUser?.userFinance,
                                        dream = state.dreamWithUser?.dream,
                                        id = state.dreamWithUser?.id
                                    )
                                )
                            }.invokeOnCompletion { model.nextStep() }
                        })
                }
                EmulateDreamsStep.CONFIRMATION -> {
                    ConfirmationAndOfferCreditStep(onClick = {
                        navController.navigate(UserRouterDir.HOME.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    })
                }
            }
        }
    }
}




