package com.example.planeando_suenos.ui.screens.home.step3.creditAmount

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun CreditAmountStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}