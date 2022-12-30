package com.example.planeando_suenos.ui.screens.register

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.register.account.AccountRegisterStep
import com.example.planeando_suenos.ui.screens.register.data.DataRegisterStep
import com.example.planeando_suenos.ui.screens.register.verify.VerifyRegisterStep
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    model: RegisterViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = true) {
        if (state.step == RegisterStep.ACCOUNT) navController.popBackStack()
        else model.prevStep()
    }

    model.state.login?.let {
        mainModel.setLogin(it)
    }

    if(model.state.name.isNotEmpty()){
        mainModel.setName(model.state.name)
    }

    if (!model.state.id.isNullOrBlank()) {
        model.nextStep()
    }

    Scaffold(
        topBar = {
            if (state.step != RegisterStep.VERIFY) {
                TopBar("Crearse una cuenta", "Comienza muy facilmente", onBackPress = {
                    if (state.step == RegisterStep.ACCOUNT) navController.popBackStack()
                    else model.prevStep()
                })
            }
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {

            RegisterStep.ACCOUNT -> AccountRegisterStep(
                onNext = model::nextStep,
                model = model
            )
            RegisterStep.DATA -> DataRegisterStep(
                onSubmit = { coroutineScope.launch { model.registerUser() }},
                model = model
            )
            RegisterStep.VERIFY -> VerifyRegisterStep(
                onNext = { coroutineScope.launch { model.loginUser() } },
            )
        }
    }
}
