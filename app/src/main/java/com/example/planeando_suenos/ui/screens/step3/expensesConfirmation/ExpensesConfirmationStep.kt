package com.example.planeando_suenos.ui.screens.step3.expensesConfirmation

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton


@Composable
fun ExpensesConfirmationStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}