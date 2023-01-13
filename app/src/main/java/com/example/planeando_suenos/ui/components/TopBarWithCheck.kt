package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness
import okhttp3.internal.wait

@Preview
@Composable
fun TopBarWithCheck() {
    Box(
        modifier = Modifier.height(150.dp)
    ){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GreenBusiness)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val formWidth = (canvasWidth * 2)
                val xPos = canvasWidth / 2

                drawArc(
                    Color.White,
                    -180f,
                    180f,
                    useCenter = false,
                    size = Size(formWidth, canvasHeight * 4),
                    topLeft = Offset(x = -xPos, y = canvasHeight - 150)
                )
            }
        }

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