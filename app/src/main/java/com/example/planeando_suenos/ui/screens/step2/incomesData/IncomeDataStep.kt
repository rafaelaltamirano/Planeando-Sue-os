package com.example.planeando_suenos.ui.screens.step2.incomesData

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun IncomeDataStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}