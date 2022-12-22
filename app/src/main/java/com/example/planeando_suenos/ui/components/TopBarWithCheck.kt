package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun TopBarWithCheck() {
    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(GreenBusiness)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(70.dp)
                    .width(10.dp)
            )
            Card(
                shape = RoundedCornerShape(100),
                modifier = Modifier
                    .size(62.dp)
                    .clip(CircleShape),
                border = BorderStroke(5.dp, Color.White),
                backgroundColor = GreenBusiness
            ) {
                Icon(
                    modifier = Modifier
                        .width(23.dp)
                        .height(16.dp)
                        .padding(16.dp),
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}