package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun TopBar(
    title: String,
    subtitle: String? = null,
    onBackPress: () -> Unit
) {

    Column(Modifier.background(GreenBusiness)) {

        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(GreenBusiness),
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1,
                    fontWeight = W700,
                    fontSize = 24.sp,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackPress) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow),
                        contentDescription = "back",
                        tint = Color.White
                    )
                }
            }
        )

        subtitle?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.subtitle1,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
            Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar("title", "subtitle", onBackPress = {})
}