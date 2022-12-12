package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R

@Composable
fun SubmitButton(
    text: String = "",
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = dimensionResource(R.dimen.gap4))
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(0),
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        Text(
            text.uppercase(),
            style = MaterialTheme.typography.button)
    }
}