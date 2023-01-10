package com.example.planeando_suenos.ui.screens.home.successSavedDream

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.DreamPromotionCardItem
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.theme.*


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuccessSavedDreamScreen(){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(BackgroundCard)
    ){
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .padding(
                        vertical = 20.dp,
                        horizontal = dimensionResource(id = R.dimen.gap5)
                    )
            ){
                Text(
                    text = "Plan de sueños\nguardado con éxito",
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    color = Color.Black,
                    lineHeight = 33.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "24 Dic 2022, 14:06",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    color = TextColorUncheckedItemDreamGrid,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.gap4),
                    horizontal = dimensionResource(id = R.dimen.gap5)
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            DreamPromotionCardItem(
                topGradientColor = TopGreenGradient,
                bottomGradientColor = BottomGreenGradient
            )
            DreamPromotionCardItem(
                topGradientColor = TopPurpleGradient,
                bottomGradientColor = BottomPurpleGradient
            )
            DreamPromotionCardItem(
                topGradientColor = TopPinkGradient,
                bottomGradientColor = BottomPinkGradient
            )
            DreamPromotionCardItem(
                topGradientColor = TopBlueGradient,
                bottomGradientColor = BottomBlueGradient
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        SubmitButton(
            text = "PEDIR",
            onClick = {  }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Regresar al inicio",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}