package com.example.planeando_suenos.ui.screens.home.step2.frecuencyIncomes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.Income
import com.example.planeando_suenos.domain.body.smartShopping.UserFinance
import com.example.planeando_suenos.ui.components.CurrencyTextField
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel

@Composable
fun ExtraIncomesStep(
    onSubmit: () -> Unit,
    model: ApproximateIncomesViewModel,
) {

    val state = model.state
    Column(
        Modifier
            .padding(dimensionResource(R.dimen.gap4))
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Tus ingresos aproximados",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        PersonalInfoCard(
            "¿Cómo son tus ingresos?",
            "Tengo sueldo variable de: ",
            state.salaryAmount.toString()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

        PersonalInfoCard(
            "¿Con qué frecuencia lo recibes?",
            state.frequencyToShow,
        )
        if (state.salaryType != "variableSalary") {
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
            CurrencyTextField(
                value = state.additionalIncomes.toString(),
                onDone = true,
                placeholder = R.string.enter_amount,
                onValueChanged = { model.setAdditionalIncomes(it.toFloat()) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )
        } else model.setAdditionalIncomes(0f)

        Spacer(Modifier.height(dimensionResource(R.dimen.gap5)))
        Row(verticalAlignment = Alignment.Bottom) {
            SubmitButton(
                text = "calcular ingresos",
                enabled = state.additionalIncomes != null,
                onClick = {
                    onSubmit()
                }
            )
        }
    }
}