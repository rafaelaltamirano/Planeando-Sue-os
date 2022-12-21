package com.example.planeando_suenos.ui.screens.step2.extraIncomes

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun ExtraIncomesStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}