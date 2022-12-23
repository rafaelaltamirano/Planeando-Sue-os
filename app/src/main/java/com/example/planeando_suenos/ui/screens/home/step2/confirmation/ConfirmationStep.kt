package com.example.planeando_suenos.ui.screens.home.step2.confirmation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithCheck
import com.example.planeando_suenos.ui.theme.TextBusiness

@Composable
fun ConfirmationStep(
    onNext: () -> Unit
) {

    Column {
        TopBarWithCheck()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.gap5)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Julián , bien hecho\n" +
                        "tus ingresos\n semanales son",
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold,
                color = TextBusiness,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "\$ 1.600.00",
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold,
                color = TextBusiness,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "22 / Dic / 2022",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                lineHeight = 24.sp
            )
            Spacer(Modifier.height(32.dp))
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "Solo nos queda calcular tus egresos",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                lineHeight = 24.sp
            )
            Spacer(Modifier.height(32.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                SubmitButton(
                    "finalizar",
                    onClick = onNext
                )
            }
        }
    }
}