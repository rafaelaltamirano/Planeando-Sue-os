package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.ui.Status
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
import com.example.planeando_suenos.ui.screens.utils.getCategoryList
import kotlinx.coroutines.launch


@Composable
fun EmulateDreamsScreen(
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    homeModel: HomeViewModel,
    navController: NavHostController
) {

    val state = model.state
    val dreamId = mainModel.state.dreamId
    val coroutineScope = rememberCoroutineScope()
    val topBarTitle: String
    val bigFont: Boolean
    val prioritySelected = remember { mutableStateOf("") }

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

    LaunchedEffect(Unit) { dreamId?.let { model.setDreamId(it) } }

    BackHandler(enabled = true) {
        model.setContentCreditSheet(false)
        if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) {
            mainModel.setDreamEdit(null)
            navController.navigate(UserRouterDir.HOME.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        } else model.prevStep()
    }

    //SET TOP BAR TITLE
    when (state.step) {
        EmulateDreamsStep.REVIEW_NUMBERS -> {
            topBarTitle = "${mainModel.state.user?.firstName}, repasemos \nestas cuentas"
            bigFont = true
        }
        EmulateDreamsStep.LIST -> {
            topBarTitle = when (state.prioritySelected) {
                "biggest" -> { "Tu sueño mas grande primero" }
                "lowest" -> { "Tu sueño mas pequeño primero" }
                "equal" -> { "Todos tus sueños al mismo tiempo" }
                 else -> { "Sueños ordenados a su gusto" }
            }
            bigFont = false
        }
        EmulateDreamsStep.CALENDAR -> {
            topBarTitle = "Calendario de pago"
            bigFont = false
        }

        EmulateDreamsStep.SAVE_DREAM -> {
            topBarTitle = "Guarda tu sueño"
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
            prioritySelected.value = it
            if (state.cancelOnNext) {
                coroutineScope.launch {
                    dreamId?.let {
                        model.getDream(dreamId, prioritySelected.value)
                        model.setStep(EmulateDreamsStep.LIST)
                    }
                }

            } else model.nextStep()
        },
        model = model,
        contentCredit = state.contentCreditSheet
    ) { expandBottomSheetFunction ->
        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                if (state.step != EmulateDreamsStep.CONFIRMATION) {
                    TopBarClearWithBack(title = topBarTitle,
                        bigFont = bigFont,
                        onBackPress = {
                            model.setContentCreditSheet(false)
                            if (state.step == EmulateDreamsStep.REVIEW_NUMBERS) {
                                mainModel.setDreamEdit(null)
                                navController.navigate(UserRouterDir.HOME.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        inclusive = true
                                    }
                                }
                            } else model.prevStep()
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
                            }.invokeOnCompletion {
                                if (state.sendToEmail) coroutineScope.launch { model.sendDreamPlanEmail() }
                                model.setCategories(getCategoryList(dreamPlan = model.state.dreamWithUser))
                                model.nextStep()
                                model.setContentCreditSheet(true)
                            }
                        })
                }
                EmulateDreamsStep.CONFIRMATION -> {
                    ConfirmationAndOfferCreditStep(
                        model = model,
                        onSubmit = expandBottomSheetFunction,
                        onClick = {
                            model.setContentCreditSheet(false)
                            homeModel.setCheckedStep1(false)
                            homeModel.setCheckedStep2(false)
                            homeModel.setCheckedStep3(false)
                            mainModel.setDreamEdit(null)
                            mainModel.setDreamId(null)
                            model.setDreamWithUser(null)
                            model.setDreamName("")
                            navController.navigate(UserRouterDir.HOME.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                            }
                            model.setStep(EmulateDreamsStep.REVIEW_NUMBERS)
                        })

                }
            }
        }
    }
}




