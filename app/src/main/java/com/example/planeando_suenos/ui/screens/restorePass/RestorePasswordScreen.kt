package com.example.planeando_suenos.ui.screens.restorePass

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.restorePass.enterEmail.EnterEmailStep
import com.example.planeando_suenos.ui.screens.restorePass.finish.FinishStep
import com.example.planeando_suenos.ui.screens.restorePass.putPassword.PutPasswordStep
import kotlinx.coroutines.launch


@Composable
fun RestorePasswordScreen(
    model: RestorePasswordViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = true) {
        if (state.step == RestorePasswordStep.ENTER_EMAIL) navController.popBackStack()
        else model.prevStep()
    }

    model.state.login?.let {
        mainModel.setLogin(it)
    }

    Scaffold(
        topBar = {
            if (state.step != RestorePasswordStep.FINISH) {
                TopBar("¿Olvidaste tu contraseña?", onBackPress = {
                    if (state.step == RestorePasswordStep.ENTER_EMAIL) navController.popBackStack()
                    else model.prevStep()
                })
            }
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {
            RestorePasswordStep.ENTER_EMAIL -> EnterEmailStep(
                onNext = model::nextStep,
                model = model
            )
            RestorePasswordStep.PUT_PASSWORD -> FinishStep(
                onNext = model::nextStep,
                model = model
            )
            RestorePasswordStep.FINISH -> PutPasswordStep(
                onNext = { coroutineScope.launch { model.submit() } },
                model = model
            )
        }
    }
}
