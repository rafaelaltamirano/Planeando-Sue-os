package com.example.planeando_suenos.ui.screens.home.step2.frecuencyIncomes

import androidx.compose.foundation.layout.*
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
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel

@Composable
fun ExtraIncomesStep(
    onNext: () -> Unit,
    model: ApproximateIncomesViewModel
) {

    val state = model.state


    Column(Modifier.padding(dimensionResource(R.dimen.gap4)).fillMaxHeight()) {

        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Tus ingresos aproximados",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        PersonalInfoCard(
            "¿Cómo son tus ingresos?",
            "Tengo sueldo variable de,",
            "1250.00"
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        PersonalInfoCard(
            "¿Con qué frecuencia lo recibes?",
            state.frequency,
        )
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "¿Tienes ingresos adicionales?",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )

        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Si los tienes, ingresa un monto semanal aproximado",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Ingresos adicionales"
        )
        CustomTextField(
            value = "Ingresa un monto aproximado",
            placeholder = R.string.enter_amount,
            onValueChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap5)))
        Row(verticalAlignment = Alignment.Bottom) {
            SubmitButton(
                text = "calcular ingresos",
                onClick = { onNext() }
            )
        }
    }
}