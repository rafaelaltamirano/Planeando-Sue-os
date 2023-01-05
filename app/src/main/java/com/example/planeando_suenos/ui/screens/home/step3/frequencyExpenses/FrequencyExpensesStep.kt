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
import androidx.compose.runtime.remember
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
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel

@Composable
fun FrequencyExpensesStep(
    model: YourExpensesIncomeViewModel,
    onNext: () -> Unit
) {

    val state = model.state
    val decimalPatter = remember { Regex("^\\d*\\.?\\d*\$") }

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
        Text(
            text = "¿Cómo son tus egresos?",
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
            value = if (state.homeExpense != null && state.homeExpense != 0.0f) {
                state.homeExpense.toString()
            } else "",
            placeholder = R.string.enter_amount,
            keyboardType = KeyboardType.Number,
            onValueChanged = {
                if (it.isEmpty() || it.matches(decimalPatter)) {
                    model.setHomeExpense(it.toFloat())
                }
            },
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
            value = if (state.transportExpense != null && state.transportExpense != 0.0f) {
                state.transportExpense.toString()
            } else "",
            placeholder = R.string.enter_amount,
            keyboardType = KeyboardType.Number,
            onValueChanged = {
                if (it.isEmpty() || it.matches(decimalPatter)) {
                    model.setTransportExpense(it.toFloat())
                }
            },
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
            value =  if (state.educationInversion != null && state.educationInversion != 0.0f) {
                state.educationInversion.toString()
            } else "",
            placeholder = R.string.enter_amount,
            onValueChanged = {
                if (it.isEmpty() || it.matches(decimalPatter)) {
                    model.setEducationInversion(it.toFloat())
                }
            },
            keyboardType = KeyboardType.Number,
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
            value = if (state.entertainmentExpense != null && state.entertainmentExpense != 0.0f) {
                state.entertainmentExpense.toString()
            } else "",
            placeholder = R.string.enter_amount,
            keyboardType = KeyboardType.Number,
            onDone = true,
            onValueChanged =  {
                if (it.isEmpty() || it.matches(decimalPatter)) {
                    model.setEntertainmentExpense(it.toFloat())
                }
            },
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