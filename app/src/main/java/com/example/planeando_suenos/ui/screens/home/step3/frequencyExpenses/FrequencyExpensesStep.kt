package com.example.planeando_suenos.ui.screens.home.step3.frequencyExpenses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel

@Composable
fun FrequencyExpensesStep(
    model: YourExpensesIncomeViewModel,
    onNext: () -> Unit
) {

    val state = model.state
    Column(
        Modifier
            .padding(horizontal = dimensionResource(R.dimen.gap4),)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
    ) {

        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Tus ingresos aproximados",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Text(
            text = "¿Cómo son tus ingresos?",
            style = MaterialTheme.typography.h2,
        )
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Calculemos juntos un promedio de gastos semanales",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Gastos del hogar"
        )
        CustomTextField(
            value = state.homeExpense,
            placeholder = R.string.enter_amount,
            onValueChanged = model::setHomeExpense,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Gastos en el transporte"
        )
        CustomTextField(
            value = state.transportExpense,
            placeholder = R.string.enter_amount,
            onValueChanged =  model::setTransportExpense,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Inversión en educación"
        )
        CustomTextField(
            value = state.educationInversion,
            placeholder = R.string.enter_amount,
            onValueChanged = model::setEducationInversion,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Gastos en entretenimiento"
        )
        CustomTextField(
            value = state.entertainmentExpense,
            placeholder = R.string.enter_amount,
            onValueChanged = model::setEntertainmentExpense,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        SubmitButton(
            text = "continuar",
            onClick = { onNext() }
        )
    }
}