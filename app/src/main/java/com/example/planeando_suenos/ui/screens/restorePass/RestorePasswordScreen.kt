package com.example.planeando_suenos.ui.screens.restorePass

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordStep.*
import com.example.planeando_suenos.ui.screens.restorePass.enterEmail.EnterEmailStep
import com.example.planeando_suenos.ui.screens.restorePass.enterPassword.EnterPasswordStep
import com.example.planeando_suenos.ui.screens.restorePass.finish.FinishStep
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
        if (state.step == ENTER_EMAIL) navController.popBackStack()
        else model.prevStep()
    }

    model.state.login?.let {
        mainModel.setLogin(it)
    }

    val headerTitle = if (state.step == ENTER_EMAIL) stringResource(R.string.forgot_pass_heder)
    else stringResource(R.string.create_new_pass)

    model.state.resetPasswordSuccess?.let {
        if (it) model.nextStep()
        model.setResetPassword(null)
    }

    Scaffold(
        topBar = {
            if (state.step != FINISH) {
                TopBar(headerTitle, onBackPress = {
                    if (state.step == ENTER_EMAIL) navController.popBackStack()
                    else model.prevStep()
                })
            }
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {
            ENTER_EMAIL -> EnterEmailStep(
                onNext = model::nextStep,
                model = model
            )
            PUT_PASSWORD -> EnterPasswordStep(
                onNext = {
                    coroutineScope.launch { model.resetPassword() }
                },
                model = model
            )

            FINISH -> FinishStep(
                onNext = { coroutineScope.launch { model.login() } }
            )
        }
    }
}
