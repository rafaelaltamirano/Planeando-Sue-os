package com.example.planeando_suenos.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.Status
import com.example.planeando_suenos.ui.Status.*
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    mainModel: MainModel,
    model: LoginModel,
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val coroutineScope = rememberCoroutineScope()


    model.status?.also {
        val (status, _) = it
        when (status) {
            NETWORK_ERROR -> mainModel.setNetworkErrorStatus(it)
            ERROR -> mainModel.setErrorStatus(it)
            INTERNET_CONNECTION_ERROR -> mainModel.setInternetConnectionError(it)
            else -> {}
        }
        model.clearStatus()
    }

    model.state.login?.let {
        mainModel.setLogin(it)
    }
    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier
                .width((configuration.screenWidthDp).dp)
                .height(configuration.screenHeightDp.dp)
                .padding(dimensionResource(R.dimen.gap5)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Sing in to your account",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
            SubmitButton(
                "login",
                onClick = { coroutineScope.launch { model.submit() } })
        }

    }

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(viewModel(), viewModel(), rememberNavController())
}