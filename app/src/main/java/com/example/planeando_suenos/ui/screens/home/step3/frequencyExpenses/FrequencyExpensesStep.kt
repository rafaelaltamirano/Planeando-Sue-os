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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CurrencyTextField
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel

@Composable
fun FrequencyExpensesStep(
    model: YourExpensesIncomeViewModel,
    onNext: () -> Unit,
    mainModel: MainViewModel
) {

    val state = model.state
    //EDIT OPTION
    LaunchedEffect(Unit) {
        if (mainModel.state.dreamEdit != null && !model.state.edited) {
            model.setHomeExpense(mainModel.state.dreamEdit?.userFinance?.expenses?.home)
            model.setTransportExpense(mainModel.state.dreamEdit?.userFinance?.expenses?.transport)
            model.setEducationInversion(mainModel.state.dreamEdit?.userFinance?.expenses?.education)
            model.setEntertainmentExpense(mainModel.state.dreamEdit?.userFinance?.expenses?.hobby)
            model.setCreditAmount(mainModel.state.dreamEdit?.userFinance?.expenses?.loanOrCredit ?: 0f)
            model.setDreamId(mainModel.state.dreamEdit?.id ?: "")
            model.setIncome(mainModel.state.dreamEdit?.userFinance?.income)
            model.setEdited(true)
        }
    }

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
        CurrencyTextField(
            value = state.homeExpense.toString(),
            placeholder = R.string.enter_amount,
            onValueChanged = {model.setHomeExpense(it.toFloat())},
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
        CurrencyTextField(
            value = state.transportExpense.toString(),
            placeholder = R.string.enter_amount,
            onValueChanged = {model.setTransportExpense(it.toFloat())},
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
        CurrencyTextField(
            value = state.educationInversion.toString(),
            placeholder = R.string.enter_amount,
            onValueChanged = {model.setEducationInversion(it.toFloat())},
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

        CurrencyTextField(
            value = state.entertainmentExpense.toString(),
            onDone = true,
            placeholder = R.string.enter_amount,
            onValueChanged = {model.setEntertainmentExpense(it.toFloat())},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        SubmitButton(
            text = stringResource(R.string.continue_),
            enabled = state.homeExpense!=null && state.transportExpense!=null &&
                    state.educationInversion!=null && state.entertainmentExpense!=null,
            onClick = { onNext() }
        )
    }
}