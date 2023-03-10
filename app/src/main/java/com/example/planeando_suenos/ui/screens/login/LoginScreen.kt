package com.example.planeando_suenos.ui.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.Status.*
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.theme.GreenBusiness
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    mainModel: MainViewModel,
    model: LoginViewModel,
    navController: NavController
) {

    val state = model.state
    val checkEmail = remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val coroutineScope = rememberCoroutineScope()

    model.status?.also {
        val (status, _) = it
        when (status) {
            NETWORK_ERROR -> mainModel.setNetworkErrorStatus(it)
            ERROR -> mainModel.setErrorStatus(it)
            INTERNET_CONNECTION_ERROR -> mainModel.setInternetConnectionError(it)
            else -> {mainModel.setNetworkErrorStatus(it)}
        }
        model.clearStatus()
    }


    model.state.login?.let {
        mainModel.setLogin(it)
    }

    Scaffold(
        topBar = {
            TopBar(
                "Entrar a tu cuenta",
                "Accede al emulador de sue??os",
                onBackPress = { navController.popBackStack() })
        },
        backgroundColor = Color.White,
    ) {

        Column(
            modifier = Modifier
                .width((configuration.screenWidthDp).dp)
                .height(configuration.screenHeightDp.dp)
                .padding(dimensionResource(R.dimen.gap5)),
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = stringResource(R.string.email)
            )

            CustomTextField(
                value = model.state.email,
                placeholder = R.string.email_example,
                leadingIcon = R.drawable.ic_arrouba,
                onValueChanged = model::setEmail,
                onFocus = model::setEmailError,
                error = model.state.emailError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )

            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = stringResource(R.string.password)
            )
            CustomTextField(
                value = model.state.password,
                placeholder = R.string.password,
                onDone = true,
                security = true,
                leadingIcon = R.drawable.ic_lock,
                onValueChanged = model::setPassword,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    stringResource(R.string.forgot_password),
                    color = GreenBusiness,
                    textAlign = TextAlign.Right,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.clickable(onClick = { navController.navigate(PublicRouterDir.RESTORE_PASS.route) }),
                    textDecoration = TextDecoration.Underline
                )
            }

            SubmitButton(
                text = stringResource(R.string.log_in),
                enabled = model.state.password!="" && model.state.email!="",
                loading = model.state.loading,
                onClick = {
                    checkEmail.value = model.validateEmail(state.email)
                    if (checkEmail.value) coroutineScope.launch { model.login() } })


            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.do_not_have_account),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    stringResource(R.string.register_it).uppercase(),
                    color = GreenBusiness,
                    textAlign = TextAlign.Center,
                    fontWeight = W700,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate(PublicRouterDir.REGISTER.route) })
                        .padding(vertical = dimensionResource(R.dimen.gap5)),
                )
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(viewModel(), viewModel(), rememberNavController())
}