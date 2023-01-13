package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.planeando_suenos.ui.theme.GreenBusiness
import java.text.DecimalFormat


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
        dreamId?.let {model.getDream(dreamId, priority ?: "")  }
    }

    val dream = model.state.dreamWithUser

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
                    amount = dream.userFinance.paymentCapability,
                    onClick = {})
                Spacer(Modifier.height(12.dp))
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
                Spacer(Modifier.height(12.dp))
            }

        }

    }
}

