package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.border
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness


@Composable
fun OutlineSubmitButton(
    text: String = "",
    onClick: () -> Unit,
    color: Color = GreenBusiness,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(R.dimen.gap4),
            horizontal = dimensionResource(R.dimen.gap5)
        )
) {
    Button(
        modifier = modifier.border( width = 2.dp,
            color = color,
            shape = RoundedCornerShape(50)),
        onClick = { onClick() },
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(
            vertical = 13.dp
        ),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color),

    ) {
        Text(
            text.uppercase(),
            color = color,
            style = MaterialTheme.typography.button,
            fontWeight = FontWeight.W900
        )
    }
}

@Preview
@Composable
private fun PreviewSubmitButtonOutline() {
    OutlineSubmitButton(
        text = "login",
        onClick = {}
    )
}