package com.example.planeando_suenos.ui.screens.home.step3.expensesData

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun ExpensesDataStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}