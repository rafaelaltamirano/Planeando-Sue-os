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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.entities.Categories
import com.example.planeando_suenos.ui.theme.*

enum class DreamCategories(val type: String) {
    CASH("efectivo"),
    HOME("hogar"),
    MOBILITY("movilidad"),
    CONNECTIVITY("conectividad")
}

@Composable
fun DreamPromotionCardItem(
    category: Categories,
) {
    val topGradientColor: Color
    val bottomGradientColor: Color
    val icon: Painter?
    val totalAmount = category.totalAmount ?: 0f
    val weekPeriod = category.period ?: 0
    val interestRatePercentage = category.percentage ?: 0f
    val amountWithInterest = (totalAmount * weekPeriod * interestRatePercentage) / 100
    val weeklyAmount = (amountWithInterest / weekPeriod).toInt()

    when (category.title) {
        DreamCategories.HOME.type -> {
            topGradientColor = TopGreenGradient
            bottomGradientColor = BottomGreenGradient
            icon = painterResource(id = R.drawable.cat_hogar)
        }
        DreamCategories.MOBILITY.type -> {
            topGradientColor = TopBlueGradient
            bottomGradientColor = BottomBlueGradient
            icon = painterResource(id = R.drawable.cat_movilidad)
        }
        DreamCategories.CONNECTIVITY.type -> {
            topGradientColor = TopPinkGradient
            bottomGradientColor = BottomPinkGradient
            icon = painterResource(id = R.drawable.cat_conectividad)
        }
        else -> {
            topGradientColor = TopPurpleGradient
            bottomGradientColor = BottomPurpleGradient
            icon = null
        }
    }

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
        ) {
            Image(
                painter = painterResource(id = R.drawable.success_card_corner_background),
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
                ) {
                    icon?.let {
                        Image(
                            painter = it,
                            contentDescription = "category",
                            modifier = Modifier
                                .width(100.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Column {
                                Text(
                                    text = "Total a pagar  $ $amountWithInterest",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de $weekPeriod semanas",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 11.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            }

                            Column {
                                Text(
                                    text = "Semanalidades de ",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "$ $weeklyAmount",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    if (icon == null) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(98.dp),
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                Text(
                                    text = "Total a pagar $ $amountWithInterest",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de $weekPeriod semanas",
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
                                    text = "$ $weeklyAmount",
                                    style = MaterialTheme.typography.subtitle2,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp,
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
