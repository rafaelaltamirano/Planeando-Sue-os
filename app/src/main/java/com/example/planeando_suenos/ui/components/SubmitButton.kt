package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun SubmitButton(
    text: String = "",
    onClick: () -> Unit,
    color: Color = GreenBusiness,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(R.dimen.gap4) )
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        shape = RoundedCornerShape(6),
        contentPadding = PaddingValues(
            vertical = 22.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            disabledBackgroundColor = Gray
        ),
    ) {
        Text(
            text,
            color = White,
            style = MaterialTheme.typography.button
        )
    }
}