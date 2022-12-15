package com.example.planeando_suenos.ui.screens.register.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.screens.register.RegisterModel

@Composable
fun AccountRegisterStep(
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
            text = "Account"
        )
        SubmitButton(
            text = "next",
            onClick = { onNext()}
        )
    }



}
