package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.ui.theme.GreenBusiness


@Composable
fun TopBarWithText(title: String) {
    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(GreenBusiness)
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                    color = Color.White
                )
            }
        }
    }
}
