package com.example.planeando_suenos.ui.screens.home.step3.creditAmount

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TextDate
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel

@Composable
fun CreditAmountStep(
    onNext: () -> Unit,
    model: YourExpensesIncomeViewModel,
) {
    val state = model.state
    Column(
        Modifier
            .padding(horizontal = dimensionResource(R.dimen.gap4))
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Tus ingresos aproximados",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        PersonalInfoCard(
            "¿Cómo son tus egresos semanales?",
            "Hogar: ",
            "1250.00",
            "Transporte: ",
            "$120.70",
            "Educación: ",
            "$220.70",
            "Entretenimiento: ",
            "$170.20"
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
        PersonalInfoCard(
            "¿Tienes algún préstamo o crédito?",
            "Si, tengo un préstamo",
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
        Text(
            modifier = Modifier.padding(end = 24.dp),
            text = "¿Tienes ingresos \nadicionales?",
            style = MaterialTheme.typography.h2,
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
            text = "¿Cuánto es el valor del crédito?"
        )
        CustomTextField(
            value = state.creditAmount,
            keyboardType = KeyboardType.Number,
            placeholder = R.string.enter_amount,
            onValueChanged = model::setCreditAmount,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "¿Cuándo dejarias de pagar el crédito?"
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
        TextDate()
        SubmitButton(
            text = "continuar",
            onClick = { onNext() }
        )
    }
}