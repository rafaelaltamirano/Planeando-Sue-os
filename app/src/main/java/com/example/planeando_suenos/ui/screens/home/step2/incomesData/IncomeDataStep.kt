package com.example.planeando_suenos.ui.screens.home.step2.incomesData

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel
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
    model: ApproximateIncomesViewModel
) {
    val selectedValue = remember { mutableStateOf("") }
    val items = listOf(IncomeItems.FIXED_SALARY, IncomeItems.VARIABLE_SALARY)
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }
    val state = model.state
    val coroutineScope = rememberCoroutineScope()

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
            text = "Necesitamos conocer tus ingresos para poder calcular tu capacidad de pago.",
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
        if (!selectedValue.value.isEmpty()) {
            val label: String
            val placeholder: Int
            if (selectedValue.value == IncomeItems.FIXED_SALARY.value) {
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
            CustomTextField(
                value = state.salaryAmount,
                placeholder = placeholder,
                onDone = true,
                onValueChanged = model::setSalaryAmount,
                keyboardType = KeyboardType.Number,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap4))
            )
            Row(verticalAlignment = Alignment.Bottom) {
                SubmitButton(
                    text = "continuar",
                    onClick = { onNext() }
                )
            }
        }
    }
}

