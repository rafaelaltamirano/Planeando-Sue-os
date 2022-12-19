package com.example.planeando_suenos.ui.components

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.Blue
import com.example.planeando_suenos.ui.theme.LightBlue

@Composable
fun PresentationCard(
    @StringRes title: Int,
    @ColorRes fontColor: Color,
    modifier: Modifier = Modifier
) {


    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            LightBlue,
            Blue
        )
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(241.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Box(Modifier.background(verticalGradientBrush)) {
            Row(Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 16.dp )) {
                Text(
                    text = stringResource(R.string.help_wishes),
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.W700,
                    color = fontColor,
                    modifier = Modifier.fillMaxWidth()
                        .align(alignment = Alignment.Bottom),
                    textAlign = TextAlign.Start,
                    maxLines = 3
                )
            }
        }
    }

}