package com.example.planeando_suenos.ui.screens.restorePass.putPassword

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun PutPasswordStep(
    onNext: () -> Unit,
    model: RestorePasswordViewModel,
) {
    Text(
        text = "screen 1",
        style = MaterialTheme.typography.h1,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        color = Color.White
    )
    SubmitButton(
        "next",
        onClick = onNext
    )
}

