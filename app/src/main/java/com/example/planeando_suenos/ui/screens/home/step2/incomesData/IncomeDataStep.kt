package com.example.planeando_suenos.ui.screens.home.step2.incomesData

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
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
import com.example.planeando_suenos.ui.screens.home.step2.incomesData.IncomeItems.*
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness
import kotlinx.coroutines.launch


enum class IncomeItems(val value: String) {
    FIXED_SALARY("Sueldo Fijo"),
    VARIABLE_SALARY("Sueldo Variable"),
}

@Composable
fun IncomeDataStep(
    onNext: () -> Unit,
    mainModel :MainViewModel,
    model: ApproximateIncomesViewModel
) {


    val selectedValue = remember { mutableStateOf("") }
    val items = listOf(FIXED_SALARY, VARIABLE_SALARY)
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }
    val state = model.state

    //EDIT OPTION
    LaunchedEffect(Unit) {
        if (mainModel.state.dreamEdit != null) {
            val res = when (mainModel.state.dreamEdit?.userFinance?.income?.type) {
                "fixedSalary" -> "Sueldo Fijo"
                else -> "Sueldo Variable"
            }
            onChangeState(res)
            model.setSalaryAmount(mainModel.state.dreamEdit?.userFinance?.income?.amount.toString())
            model.setFrequency(mainModel.state.dreamEdit?.userFinance?.income?.frequency ?: "")
            model.setAdditionalIncomes(mainModel.state.dreamEdit?.userFinance?.income?.additionalIncomeAmount.toString())
            model.setDreamId(mainModel.state.dreamEdit?.id ?: "")
        }
    }


    Column(Modifier.padding(dimensionResource(R.dimen.gap4)).fillMaxHeight()) {
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
            text = "Conocer tus ingresos te ayudará a calcular tu capacidad disponible",
            fontSize = 15.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 24.sp
        )
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = isSelectedItem(item.value),
                        onClick = { onChangeState(item.value) },
                        role = Role.RadioButton
                    )
                    .padding(14.dp)
            ) {
                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = GreenBusiness,
                        unselectedColor = Color.DarkGray,
                        disabledColor = Color.LightGray
                    ),
                    selected = isSelectedItem(item.value),
                    onClick = null
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = item.value,
                    style = MaterialTheme.typography.caption,
                    fontSize = 15.sp,
                    color = TextBusiness
                )

            }
        }
        Spacer(Modifier.height(32.dp))
        if (selectedValue.value.isNotEmpty()) {
            val label: String
            val placeholder: Int
            if (selectedValue.value == FIXED_SALARY.value) {
                label = stringResource(R.string.fixed_salary)
                placeholder = R.string.enter_amount
            } else {
                label = stringResource(R.string.variable_salary)
                placeholder = R.string.approximately_income
            }
            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = label
            )
            CurrencyTextField(
                value = state.salaryAmount ?: "",
                placeholder = placeholder,
                onValueChanged = {model.setSalaryAmount(it)},
                onDone = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )

            Row(verticalAlignment = Alignment.Bottom) {
                SubmitButton(
                    text = "continuar",
                    enabled = state.salaryAmount!=null,
                    onClick = {
                        model.setSalaryType(
                            when(selectedValue.value){
                                FIXED_SALARY.value -> "fixedSalary"
                                else -> "variableSalary"
                            })
                        onNext() }
                )
            }
        }
    }
}

