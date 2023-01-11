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
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R


@Composable
fun OutlineCardButton(
    text: String = "",
    onClick: () -> Unit,
    color: Color = Color.White,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(
            vertical = dimensionResource(R.dimen.gap3),
            horizontal = 12.dp
        )){
    Button(
        modifier = modifier.border( width = 2.dp,
            color = color,
            shape = RoundedCornerShape(25)
        ),

        onClick = { onClick() },
        shape = RoundedCornerShape(0),
        contentPadding = PaddingValues(
            top = 13.dp, bottom = 13.dp, start = 13.dp
        ),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color,
            backgroundColor = Color.Transparent),

        ) {
        Text(
            modifier = Modifier.weight(0.8f),
             text = text,
            color = color,
            style = MaterialTheme.typography.caption,
        )
        Icon(
            modifier = Modifier.weight(0.2f),
            painter = painterResource(R.drawable.ic_icon_mayus),
            contentDescription = "next",
            tint = Color.White
        )
    }

}