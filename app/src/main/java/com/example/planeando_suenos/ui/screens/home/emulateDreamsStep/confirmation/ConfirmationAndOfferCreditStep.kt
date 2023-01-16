package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.confirmation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.DreamPromotionCardItem
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithCheck
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.screens.utils.convertDateToFormat
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import java.util.*


@Composable
fun ConfirmationAndOfferCreditStep(
    onClick: () -> Unit,
    onSubmit: () -> Unit,
    model: EmulateDreamsViewModel
) {


    val dateTimeToday = Calendar.getInstance().time.convertDateToFormat("dd MMM yyyy, hh:mm")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopBarWithCheck()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 0.dp,
                    start = dimensionResource(R.dimen.gap5),
                    end = dimensionResource(R.dimen.gap5),
                    bottom = dimensionResource(R.dimen.gap5)
                ),
        ) {
            Text(
                text = "¡Te ayudamos a cumplir\n tus sueños hoy!",
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                color = Color.Black,
                lineHeight = 33.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = dateTimeToday,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = TextColorUncheckedItemDreamGrid,
            )
            Spacer(modifier = Modifier.height(27.dp))

            model.state.categories.forEach {
                DreamPromotionCardItem(category = it)
                Spacer(modifier = Modifier.height(20.dp))
            }

            SubmitButton(
                text = "pedir",
                onClick = onSubmit
            )
            Row(
                Modifier
                    .padding(dimensionResource(R.dimen.gap4))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Regresar al inicio",
                    color = Accent,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .clickable(onClick = {
                            onClick()
                        }),
                )
            }
        }
    }
}

