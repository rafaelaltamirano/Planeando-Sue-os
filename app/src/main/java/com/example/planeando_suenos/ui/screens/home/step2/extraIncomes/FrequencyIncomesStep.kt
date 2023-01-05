package com.example.planeando_suenos.ui.screens.home.step2.extraIncomes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step2.ApproximateIncomesViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

enum class Frecuency(val value: String) {
    Diario("diary"),
    Semanal("weekly"),
    Quincenal("biweekly"),
    Mensual("monthly"),
}

@Composable
fun FrequencyIncomesStep(
    onNext: () -> Unit,
    model: ApproximateIncomesViewModel
) {
    val state = model.state
    val selectedValue = remember { mutableStateOf("") }
    val items = listOf("Diario", "Semanal", "Quincenal", "Mensual")
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    Column(
        Modifier
            .padding(dimensionResource(R.dimen.gap4))
            .fillMaxHeight()
    ) {

        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Tus ingresos aproximados",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        PersonalInfoCard(
            "¿Cómo son tus ingresos?",
            "Tengo sueldo variable de,",
            state.salaryAmount.toString()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

        Text(
            modifier = Modifier.padding(end = 24.dp),
            text = "¿Con qué frecuencia lo recibes?",
            style = MaterialTheme.typography.h2,
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = isSelectedItem(item),
                        onClick = { onChangeState(item) },
                        role = Role.RadioButton
                    )
                    .padding(6.dp)
            ) {

                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = GreenBusiness,
                        unselectedColor = Color.DarkGray,
                        disabledColor = Color.LightGray
                    ),
                    selected = isSelectedItem(item),
                    onClick = null
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = item,
                    style = MaterialTheme.typography.caption,
                    fontSize = 15.sp,
                    color = TextBusiness
                )
            }
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        Row(verticalAlignment = Alignment.Bottom) {
            SubmitButton(
                text = "continuar",
                enabled = selectedValue.value != "",
                onClick = {
                    val frequency = when (selectedValue.value) {
                        "Diario" -> "diary"
                        "Semanal" -> "weekly"
                        "Quincenal" -> "biweekly"
                        "Mensual" -> "monthly"
                        else -> {""}
                    }
                    model.setFrequencyToShow(selectedValue.value)
                    model.setFrequency(frequency)
                    onNext()
                }
            )
        }
    }
}