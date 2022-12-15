package com.example.planeando_suenos.ui.screens.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.screens.register.account.AccountRegisterStep
import com.example.planeando_suenos.ui.screens.register.data.DataRegisterStep
import com.example.planeando_suenos.ui.screens.register.verify.VerifyRegisterStep

@Composable
fun RegisterScreen(
    model: RegisterModel,
    mainModel: MainModel,
    navController: NavHostController
) {


    val state = model.state

    when (state.step) {

        RegisterStep.ACCOUNT -> AccountRegisterStep(
            onNext = model::nextStep,
        )
        RegisterStep.DATA -> DataRegisterStep(
            onNext = model::nextStep,
        )
        RegisterStep.VERIFY -> VerifyRegisterStep(
            onNext = { navController.navigate(PublicRouterDir.LOGIN.route)},
        )
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