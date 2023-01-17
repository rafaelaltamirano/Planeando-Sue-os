package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.AmountCard
import com.example.planeando_suenos.ui.components.CardType
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.GreenBusiness


@Composable
fun ReviewNumbersStep(
    onNext: () -> Unit,
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    onShowBottomSheet: () -> Unit,
    navController: NavHostController
) {
    val dreamId = mainModel.state.dreamId
    val priority = model.state.prioritySelected

    LaunchedEffect(Unit) {
        dreamId?.let { model.getDream(dreamId, priority ?: "") }
    }

    val dream = model.state.dreamWithUser

    val capabilityToConvert = dream?.userFinance?.initialPaymentCapability ?: dream?.userFinance?.paymentCapability

    val paymentCapabilityWithPercentage = capabilityToConvert?.times(model.state.percentageSlider / 100)

    if (dream == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {

        Column(
            Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        )
        {
            Column(
                Modifier
                    .padding(dimensionResource(R.dimen.gap4))
                    .fillMaxHeight()
            ) {
                AmountCard(
                    type = CardType.INCOMES,
                    amount = dream.userFinance?.income!!.totalIncome,
                    onClick = {
                        mainModel.setDreamEdit(dream)
                        navController.navigate(UserRouterDir.STEP_2.route)
                    })
                Spacer(Modifier.height(12.dp))
                AmountCard(
                    type = CardType.EXPENSES,
                    amount = dream.userFinance.expenses!!.totalExpense,
                    onClick = {
                        mainModel.setDreamEdit(dream)
                        navController.navigate(UserRouterDir.STEP_3.route)
                    })
                Spacer(Modifier.height(12.dp))
                AmountCard(
                    type = CardType.CAPACITY_DREAM,
                    amount = paymentCapabilityWithPercentage,
                    onClick = {})
                Spacer(Modifier.height(12.dp))

                if (paymentCapabilityWithPercentage!! > 0) {
                    PercentageSlider(model.state.percentageSlider) {
                        model.setPercentageSlider(it)
                    }
                    Spacer(Modifier.height(24.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 14.dp),
                        text = "Elige alguna de las opciones que están pre cargadas para ayudarte a cumplir tu sueño.",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "elige como  cumplir tu sueño  >".uppercase(),
                            color = GreenBusiness,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .clickable(onClick = { onShowBottomSheet() }),
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFCDEE0), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Tu capacidad de pago no puede ser negativa. Por favor edita tus ingresos o egresos.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W400,
                            lineHeight = 24.sp,
                            color = Color(0xFFAF272F)
                        )
                    }
                }
                Spacer(Modifier.height(12.dp))

            }

        }

    }
}

@Composable
fun PercentageSlider(percentageSlider: Float, onPercentageChange: (Float) -> Unit) {
    val range = 10.0f..100.0f
    val steps = 8
    Text(
        text = "${percentageSlider.toInt()}%",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Accent
    )
    Spacer(modifier = Modifier.height(4.dp))
    Slider(
        value = percentageSlider,
        onValueChange = { onPercentageChange(it) },
        steps = steps,
        valueRange = range,
        colors = SliderDefaults.colors(
            thumbColor = Accent
        )
    )
}

