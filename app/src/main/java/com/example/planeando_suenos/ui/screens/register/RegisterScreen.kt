package com.example.planeando_suenos.ui.screens.register

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.router.Root
import com.example.planeando_suenos.ui.screens.register.account.AccountRegisterStep
import com.example.planeando_suenos.ui.screens.register.data.DataRegisterStep
import com.example.planeando_suenos.ui.screens.register.verify.VerifyRegisterStep

//
//data class HeaderData(
//    val title: String = "",
//    val subtitle: String? = null
//)

@Composable
fun RegisterScreen(
    model: RegisterViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == RegisterStep.ACCOUNT) navController.popBackStack()
        else model.prevStep()
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
                onNext = model::nextStep,
            )
            RegisterStep.VERIFY -> VerifyRegisterStep(
                onNext = { navController.navigate(PublicRouterDir.LOGIN.route) },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(
        viewModel(),
        viewModel(),
        rememberNavController()
    )
}