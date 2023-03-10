package com.example.planeando_suenos.ui.screens.home.step3.creditAmount

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.*
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel
import com.example.planeando_suenos.ui.screens.utils.toDateString

@Composable
fun CreditAmountStep(
    onNext: () -> Unit,
    model: YourExpensesIncomeViewModel,
) {
    val state = model.state
    val amountCreditToShow = remember {mutableStateOf("")}
     if(state.creditAmount.isNullOrBlank()) amountCreditToShow.value = "" else amountCreditToShow.value = state.creditAmount.toString()

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
            "¿Cómo son tus gastos semanales?",
            "Hogar: ",
            state.homeExpense.toString(),
            "Transporte: ",
            state.transportExpense.toString(),
            "Educación: ",
            state.educationInversion.toString(),
            "Entretenimiento: ",
            state.entertainmentExpense.toString()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
        PersonalInfoCard(
            "¿Tienes algún préstamo o crédito?",
            state.creditText,
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        if (state.hasCredit) {
            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = "¿Cuánto es el valor del crédito?"
            )
            CurrencyTextField(
                value = amountCreditToShow.value?:"",
                placeholder =  R.string.enter_amount,
                onValueChanged = {model.setCreditAmount(it)},
                onDone = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = "¿Cuándo dejarias de pagar el crédito?"
            )
            val dateShow = if(state.creditEndDate!=null) state.creditEndDate.toDateString("dd/MM/yyyy")
            else null
            Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))
            TextDate(onValueChanged = { model.setCreditEndDate(it)},dateToShow = dateShow)
        }
        SubmitButton(
            text = stringResource(R.string.continue_),
            enabled = !state.hasCredit || !state.creditEndDate.isNullOrBlank() && amountCreditToShow.value.isNotEmpty(),
            onClick = { onNext() }
        )
    }
}