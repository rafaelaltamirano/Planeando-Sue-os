package com.example.planeando_suenos.ui.screens.step1.dreamsType

import androidx.compose.runtime.Composable
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun DreamsTypeStep(
    onNext: () -> Unit
) {

    SubmitButton(
        text = "next",
        onClick = { onNext() }
    )
}