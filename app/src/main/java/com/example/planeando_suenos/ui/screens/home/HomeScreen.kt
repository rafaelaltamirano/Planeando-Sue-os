package com.example.planeando_suenos.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.Status
import com.example.planeando_suenos.ui.components.CardChecked
import com.example.planeando_suenos.ui.components.OutlineCardButton
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness


@Composable
fun HomeScreen(
    model: HomeViewModel,
    navController: NavHostController,
    mainModel: MainViewModel
) {

    val mainState = mainModel.state
    val state = model.state

    val dreamId = mainState.dreamId

    if (!dreamId.isNullOrBlank()) {
        LaunchedEffect(Unit) {
            model.getDreamById(dreamId)
        }
    }

    val dreamWithUser = state.dreamWithUser

    val subtitleIncomeFrequency = when(dreamWithUser?.userFinance?.income?.frequency) {
        "diary" -> "diarios"
        "weekly" -> "semanales"
        "biweekly" -> "quincenales"
        "monthly" -> "mensuales"
        else -> ""
    }

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

    LaunchedEffect(Unit) {
        model.getUserById(mainState.login?.id ?: "")
            .invokeOnCompletion { mainModel.setUser(model.state.user!!) }
        model.getDream()
    }

    if (state.dreamWithUserList != null) mainModel.setDreamWithUserList(state.dreamWithUserList)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopBarWithComponent(name = model.state.user?.firstName ?: "",
            showButton = !state.dreamWithUserList.isNullOrEmpty(),
            loading = state.loading,
            onClick = {
                navController.navigate(UserRouterDir.MY_DREAMS.route)

            })

        Column(
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                )
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Somos los aliados de tus sueños. Para ayudarte a planificar tu compra debemos conocer un poco mas sobre:",
                fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Paso 1",
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                color = TextBusiness
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = model.state.checkedStep1,
                title = "Tus sueños y aspiraciones",
                subTitle = "Datos completados con éxito",
                onClick = {
                    if (!model.state.checkedStep1) {
                        navController.navigate(UserRouterDir.STEP_1.route)
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Paso 2",
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                color = if (model.state.checkedStep1) TextBusiness else GrayBusiness
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = model.state.checkedStep2,
                enable = model.state.checkedStep1,
                title = "Tus ingresos aproximados",
                subTitle = "$ ${dreamWithUser?.userFinance?.income?.totalIncome} $subtitleIncomeFrequency",
                onClick = {
                    if (!model.state.checkedStep2) {
                        navController.navigate(UserRouterDir.STEP_2.route)
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Paso 3",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = if (model.state.checkedStep1 && model.state.checkedStep2) TextBusiness else GrayBusiness
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = model.state.checkedStep3,
                enable = model.state.checkedStep1 && model.state.checkedStep2,
                title = "Tus gastos",
                subTitle = "$ ${dreamWithUser?.userFinance?.expenses?.totalExpense} semanales",
                onClick = {
                    if (!model.state.checkedStep3) {
                        navController.navigate(UserRouterDir.STEP_3.route)
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Es fácil y rápido. ¿Estás listo?",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextBusiness
            )
        }
        Row(verticalAlignment = Alignment.Bottom) {
            SubmitButton(
                text ="emular sueños",
                enabled =  model.state.checkedStep1 && model.state.checkedStep2 && model.state.checkedStep3,
                onClick = { navController.navigate(UserRouterDir.EMULATE_DREAM.route) }
            )
        }

    }


}

@Composable
fun TopBarWithComponent(name: String, onClick: () -> Unit,
                        showButton: Boolean,
                        loading: Boolean) {
    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(GreenBusiness)
        ) {
            Text(
                text = "Planeando sueños",
                modifier = Modifier.padding(start = 24.dp, top = 16.dp),
                color = Color.White
            )
        }
        Column {
            Spacer(
                modifier = Modifier
                    .height(70.dp)
                    .width(10.dp)
            )
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(6.dp),
                elevation = 4.dp,
                backgroundColor = Accent
            ) {
                if (loading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            color = Color.White
                        )
                    }
                }
                else {
                    Column {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "¡Hola $name!",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 17.sp
                        )
                        if (showButton) {
                            OutlineCardButton(
                                text = "Tu plan de sueños guardados",
                                onClick = { onClick() })

                        }
                    }
                }
            }
        }
    }
}

