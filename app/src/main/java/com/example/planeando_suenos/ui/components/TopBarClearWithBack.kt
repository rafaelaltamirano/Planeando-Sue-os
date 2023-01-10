package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.Accent

@Composable
fun TopBarClearWithBack(
    title: String? = null,
    onBackPress: () -> Unit,
    bigFont: Boolean
) {

    Column(
        Modifier
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center
    ) {

        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Transparent),
            title = {
                if (!bigFont) {
                        title?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.h1,
                                fontWeight = FontWeight.W700,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                }

            },
            navigationIcon = {
                IconButton(onClick = onBackPress) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow),
                        contentDescription = "back",
                        tint = Accent
                    )
                }
            }
        )
        if (bigFont) {
            Row(modifier = Modifier.padding(horizontal = 24.dp)) {
                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h1,
                        fontWeight = FontWeight.W700,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopBarClearWithBack() {
    Column {
        TopBarClearWithBack("title", onBackPress = {}, true)
        TopBarClearWithBack(onBackPress = {}, bigFont = true)
    }
}