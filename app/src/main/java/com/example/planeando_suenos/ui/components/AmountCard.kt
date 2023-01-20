package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.theme.*
import java.text.DecimalFormat

enum class CardType(val value: String) {
    INCOMES("Tus ingresos"),
    EXPENSES("Tus gastos"),
    CAPACITY_DREAM("Tu monto disponible \npara cumplir sueños")
}

@Composable
fun AmountCard(
    type: CardType = CardType.INCOMES,
    amount: Float? = null,
    onClick: () -> Unit,
) {
    val backgroundColor = if (type == CardType.CAPACITY_DREAM) Accent else WhiteBusiness
    val simbol = when (type) {
        CardType.INCOMES -> ""
        CardType.EXPENSES -> "_"
        CardType.CAPACITY_DREAM -> "="
    }
    val dec = DecimalFormat("#,###.00")
    val amountWithComa = dec.format(amount)
    val amountBeforeDecimal = amountWithComa.toString().substringBefore(".")
    val amountAfterDecimals = amountWithComa.toString().substringAfterLast(".").take(2).replace(",","0")

    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onClick()
            },
        elevation = 5.dp,
        backgroundColor = backgroundColor,

        ) {
        Row(
            modifier = Modifier.padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(start = 14.dp, top = 14.dp, bottom = 6.dp),
                verticalArrangement = Arrangement.Center
            ) {
                if (type == CardType.CAPACITY_DREAM) {
                    Text(
                        style = MaterialTheme.typography.caption,
                        text = type.value,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = BackgroundCard
                    )
                } else {
                    ResizeText(
                        text = type.value,
                        color = TextColorUncheckedItemDreamGrid,
                        style = TextStyle(
                            fontFamily = AvenirNext,
                            fontWeight = FontWeight.W400,
                            fontSize = 15.sp,
                        ),
                        modifier = Modifier
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    style = MaterialTheme.typography.caption,
                    text = if (type != CardType.CAPACITY_DREAM) "Editar" else "",
                    color = Accent,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W700,
                )
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 8.dp),
                    color = if (type == CardType.CAPACITY_DREAM) BackgroundCard else GreenBusiness,
                    style = MaterialTheme.typography.caption,
                    text = simbol,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W900,
                )
                Column {
                    Row(
                        modifier = Modifier.weight(1.1f),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            color = if (type == CardType.CAPACITY_DREAM) BackgroundCard else GreenBusiness,
                            style = MaterialTheme.typography.caption,
                            text = "$",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W900,
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.9f))
                }
                    ResizeText(
                        text = amountBeforeDecimal,
                        color = if (type == CardType.CAPACITY_DREAM) BackgroundCard else GreenBusiness,
                        style = TextStyle(
                            fontFamily = AvenirNext,
                            fontWeight = FontWeight.W700,
                            fontSize = 24.sp,
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
                            color = if (type == CardType.CAPACITY_DREAM) BackgroundCard else GreenBusiness,
                            style = TextStyle(
                                fontFamily = AvenirNext,
                                fontWeight = FontWeight.W700,
                                fontSize = 18.sp,
                            ),
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.9f))
                }
            }
        }
    }
}

