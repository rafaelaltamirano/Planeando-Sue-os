package com.example.planeando_suenos.ui.screens.register.verify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.planeando_suenos.ui.components.SubmitButton

@Composable
fun VerifyRegisterStep(
    onNext: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            text = "Verify"
        )
        SubmitButton(
            text = "next",
            onClick = { onNext()}
        )
    }

}
