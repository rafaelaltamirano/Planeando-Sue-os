package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.reviewNumbers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.AmountCard
import com.example.planeando_suenos.ui.components.CardType
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness
import java.util.*


@Composable
fun ReviewNumbersStep(
    onNext: () -> Unit,
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    onShowBottomSheet : () -> Unit
) {
    val name = mainModel.state.name
    Column(Modifier.fillMaxHeight().verticalScroll(rememberScrollState()))
    {
        TopBarWithText()
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(125.dp),
        ) {
            Text(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 18.dp
                ),
                text = "$name, repasemos \nestas cuentas",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp
            )
        }
        Column(
            Modifier
                .padding(dimensionResource(R.dimen.gap4))
                .fillMaxHeight()
        ) {


            AmountCard(CardType.INCOMES, "1,6000.00", {})
            Spacer(Modifier.height(12.dp))
            AmountCard(CardType.EXPENSES, "861.40", {})
            Spacer(Modifier.height(12.dp))
            AmountCard(CardType.CAPACITY_DREAM, "739.40", {})
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

@Composable
fun TopBarWithText() {
    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(GreenBusiness)
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Planeando sueños",
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                    color = Color.White
                )
            }
        }
    }
}
