package com.example.planeando_suenos.ui.screens.home.step3.creditQuestion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

@Composable
fun CreditQuestionStep(
    onNext: () -> Unit
) {
    val selectedValue = remember { mutableStateOf("") }

    val items = listOf("Si, tengo un préstamo", "No. No tengo préstamos")
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

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
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

        Text(
            text = "¿Tienes algún préstamo o crédito?",
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
        SubmitButton(
            text = "continuar",
            onClick = { onNext() }
        )
    }
}