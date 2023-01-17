package com.example.planeando_suenos.ui.screens.home.step3.creditQuestion

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.PersonalInfoCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.home.step3.YourExpensesIncomeViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

@Composable
fun CreditQuestionStep(
    model: YourExpensesIncomeViewModel,
    onNext: () -> Unit,
    mainModel: MainViewModel
) {
    val selectedValue = remember { mutableStateOf("") }
    val state = model.state
    val items = listOf("Si, tengo un préstamo", "No, no tengo préstamos")
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    LaunchedEffect(Unit) {
        if (mainModel.state.dreamEdit != null) {
            if (mainModel.state.dreamEdit?.userFinance?.expenses?.loanOrCredit!! > 0f) {
                onChangeState("Si, tengo un préstamo")
                model.setCreditEndDate(mainModel.state.dreamEdit?.userFinance?.expenses?.loanOrCreditPaymentDate)
                model.setCreditText("Si, tengo un préstamo")
                model.setHasCredit(false)
            } else {
                onChangeState("No, No tengo préstamos")
                model.setCreditText("No, No tengo préstamos")
                model.setHasCredit(false)
            }
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
                            onClick = {
                                if (item == "Si, tengo un préstamo") {
                                    model.setHasCredit(true)
                                    model.setCreditText(item)
                                } else {
                                    model.setHasCredit(false)
                                    model.setCreditText(item)
                                }
                                onChangeState(item)
                            },
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
                text = stringResource(R.string.continue_),
                enabled = selectedValue.value != "",
                onClick = {
                    onNext()
                }
            )
        }
    }