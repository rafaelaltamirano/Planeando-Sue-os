package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.BottomGreenGradient
import com.example.planeando_suenos.ui.theme.TopGreenGradient


@Composable
fun DreamPromotionCardItem(
    painter: Painter? = null,
    topGradientColor : Color,
    bottomGradientColor: Color,
){
    Box(
        modifier = Modifier
            .height(191.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                /* TODO */
            }
    ) {
        Box(
            modifier = Modifier
                .height(191.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            topGradientColor,
                            bottomGradientColor
                        )
                    )
                )
        ){
            Image(
                painter = painterResource(id =R.drawable.success_card_corner_background),
                contentDescription = "card background",
                modifier = Modifier
                    .alpha(0.5F)
                    .height(191.dp)
            )
            Column {
                Text(
                    text = "Con Crédito Elektra consigue\ncumplir tu sueño en simples pasos.",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.W700,
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.gap5),
                            vertical = 19.dp
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.gap5)
                        ),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ){
                    painter?.let {
                        Image(
                            painter = it,
                            contentDescription = "category",
                            modifier = Modifier
                                .width(100.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ){
                            Column {
                                Text(
                                    text = "Total a pagar  $675.33",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de 20 a 23 semanas",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            }

                            Column {
                                Text(
                                    text = "Semanalidades de",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "$30.00 a $33.77",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 22.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    if(painter == null) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(24.dp)
                        ){
                            Column(
                                modifier = Modifier
                                    .width(98.dp),
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ){
                                Text(
                                    text = "Total a pagar $675.33",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de 20 a 23 semanas",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            }

                            Column {
                                Text(
                                    text = "Semanalidades de",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "$30.00 a $33.77",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 22.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDreamPromotionCardItem() {
    
    Column {
        DreamPromotionCardItem(
            topGradientColor = TopGreenGradient, 
            bottomGradientColor = BottomGreenGradient
        )
        Spacer(modifier = Modifier.height(10.dp))
        DreamPromotionCardItem(
            painter = painterResource(id = R.drawable.cat_conectividad),
            topGradientColor = TopGreenGradient, 
            bottomGradientColor = BottomGreenGradient
        )
    }
}