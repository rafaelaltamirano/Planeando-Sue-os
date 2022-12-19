package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R

@Composable
fun ValidatorMessage(message: String, isValid: Boolean?) {

    val color = when(isValid){
        true -> Green
        false-> Red
        else -> Gray
    }
    val bullet = "\u2022"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.gap4),
                vertical = dimensionResource(R.dimen.gap2)
            )
    ) {
        Row {
            Text(
                text = bullet,
                color = color,
                style = MaterialTheme.typography.caption,
                fontSize = 12.sp
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = message,
                color = color,
                style = MaterialTheme.typography.caption,
                fontSize = 12.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun previewValidatorMessage() {
    ValidatorMessage(
        message = "prueba",
        true
    )
}