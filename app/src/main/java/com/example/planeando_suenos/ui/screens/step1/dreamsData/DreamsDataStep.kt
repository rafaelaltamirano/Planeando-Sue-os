package com.example.planeando_suenos.ui.screens.step1.dreamsData

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun DreamsDataStep(
    onNext: () -> Unit
) {
    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )

}