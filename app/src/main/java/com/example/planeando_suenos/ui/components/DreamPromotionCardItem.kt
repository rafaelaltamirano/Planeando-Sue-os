package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.entities.Categories
import com.example.planeando_suenos.ui.theme.*
import java.text.DecimalFormat

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
    val amountToPay = category.amountToPay ?: 0f
    val weekFrom = category.weekFrom ?: 0
    val weekTo = category.weekTo ?: 0
    val amountWeekFrom = category.amountWeekFrom ?: 0f
    val amountWeekTo = category.amountWeekTo ?: 0f


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
                                    text = "Total a pagar $$amountToPay",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de $weekFrom a $weekTo semanas",
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
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AmountTextView(amountWeekFrom)

                                    Text(
                                        text = " a ",
                                        style = MaterialTheme.typography.subtitle2,
                                        fontWeight = FontWeight.W700,
                                        fontSize = 12.sp,
                                        lineHeight = 20.sp,
                                        color = Color.White
                                    )

                                    AmountTextView(amountWeekTo)
                                }
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
                                    text = "Total a pagar $$amountToPay",
                                    style = MaterialTheme.typography.subtitle1,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Plazo de $weekFrom a $weekTo semanas",
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
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AmountTextView(amountWeekFrom)
                                    Text(
                                        text = " a ",
                                        style = MaterialTheme.typography.subtitle2,
                                        fontWeight = FontWeight.W700,
                                        fontSize = 12.sp,
                                        lineHeight = 20.sp,
                                        color = Color.White
                                    )
                                    AmountTextView(amountWeekTo)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun AmountTextView(amount: Float) {
    val dec = DecimalFormat("#,###.##")
    val amountWithComa = dec.format(amount)
    val amountBeforeDecimal = amountWithComa.toString().substringBefore(".")
    val amountAfterDecimals =
        amountWithComa.toString().substringAfterLast(".").take(2).replace(",", "0")

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                modifier = Modifier.weight(1.1f),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    color = Color.White,
                    style = MaterialTheme.typography.caption,
                    text = "$",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W900,
                )
            }
            Spacer(modifier = Modifier.weight(0.9f))
        }
        ResizeText(
            text = amountBeforeDecimal,
            color = Color.White,
            style = TextStyle(
                fontFamily = AvenirNext,
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
            ),
            modifier = Modifier
        )
        Column {
            Row(
                modifier = Modifier.weight(1.1f),
                verticalAlignment = Alignment.Bottom
            ) {
                ResizeText(
                    text = ".$amountAfterDecimals",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = AvenirNext,
                        fontWeight = FontWeight.W700,
                        fontSize = 15.sp,
                    ),
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.weight(0.9f))
        }
    }
}

