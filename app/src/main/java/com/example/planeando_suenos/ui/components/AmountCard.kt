package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.BackgroundCard
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid

enum class CardType(val value: String) {
    INCOMES("Tus ingresos"),
    EXPENSES("Tus egresos y gastos"),
    CAPACITY_DREAM("Tu capacidad disponible para cumplir sueños")
}

@Composable
fun AmountCard(
    type: CardType = CardType.INCOMES,
    amount: String? = null,
    onClick: () -> Unit,
) {
    var onSelect by remember { mutableStateOf(false) }
    val backgroundColor = if (onSelect) Accent else Color.Transparent
    val simbol = when (type) {
        CardType.INCOMES -> ""
        CardType.EXPENSES -> "_"
        CardType.CAPACITY_DREAM -> "="
    }

    Card(
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(10))
            .clickable {
                onSelect = true
                onClick
            },
        elevation = 2.dp,
        backgroundColor = backgroundColor,

        ) {
        Row(
            modifier = Modifier.padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(0.8f)
                    .padding(start = 14.dp, top = 14.dp, bottom = 6.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = MaterialTheme.typography.caption,
                    text = type.value,
                    color = if (onSelect) BackgroundCard else TextColorUncheckedItemDreamGrid,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    style = MaterialTheme.typography.caption,
                    text = if (!onSelect) "Editar" else "",
                    color = Accent,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                )
            }
            Row(
                modifier = Modifier.weight(1.2f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 8.dp),
                    color = if (onSelect) BackgroundCard else GreenBusiness,
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
                            color = if (onSelect) BackgroundCard else GreenBusiness,
                            style = MaterialTheme.typography.caption,
                            text = "$",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W900,
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.9f))
                }
                amount?.let {
                    Text(
                        color = if (onSelect) BackgroundCard else GreenBusiness,
                        style = MaterialTheme.typography.caption,
                        text = "$amount",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.W700,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmountCardPreview() {
    AmountCard(CardType.INCOMES, "861.40", {})
}