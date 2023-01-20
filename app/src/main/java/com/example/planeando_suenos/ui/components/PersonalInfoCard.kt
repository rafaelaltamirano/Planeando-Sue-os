package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.WhiteBusiness
import java.text.DecimalFormat

@Composable
fun PersonalInfoCard(
    title: String,
    subtitle: String,
    amount: String? = null,
    subtitle2: String? = null,
    amount2: String? = null,
    subtitle3: String? = null,
    amount3: String? = null,
    subtitle4: String? = null,
    amount4: String? = null,
) {
    val dec = DecimalFormat("#,###.00")
    val amountFormat = amount?.let {dec.format(amount.toFloat()) }
    val amount2Format = amount2?.let {dec.format(amount2.toFloat()) }
    val amount3Format = amount3?.let {dec.format(amount3.toFloat()) }
    val amount4Format = amount4?.let {dec.format(amount4.toFloat()) }

    Card(
        shape = RoundedCornerShape(10),
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10)),
        border = BorderStroke(1.dp, TextColorUncheckedItemDreamGrid),
        backgroundColor = WhiteBusiness
    ) {
        Column() {
            Text(
                modifier = Modifier.padding(start = 14.dp, top = 14.dp,bottom = 6.dp),
                style = MaterialTheme.typography.caption,
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
            )
           Row(verticalAlignment = Alignment.CenterVertically) {
               Text(
                   color = TextColorUncheckedItemDreamGrid,
                   modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp),
                   style = MaterialTheme.typography.caption,
                   text = subtitle,
                   fontSize = 14.sp,
                   fontWeight = FontWeight.W400,
               )
               amountFormat?.let {
                   Text(
                       color = TextColorUncheckedItemDreamGrid,
                       style = MaterialTheme.typography.caption,
                       text = " \$ $amountFormat",
                       fontSize = 14.sp,
                       fontWeight = FontWeight.W700,
                   )
               }
           }
            subtitle2?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        color = TextColorUncheckedItemDreamGrid,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.caption,
                        text = subtitle2,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )
                    amount2Format?.let {
                        Text(
                            color = TextColorUncheckedItemDreamGrid,
                            style = MaterialTheme.typography.caption,
                            text = "\$ $amount2Format",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                        )
                    }
                }
            }
            subtitle3?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        color = TextColorUncheckedItemDreamGrid,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.caption,
                        text = subtitle3,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )
                    amount3Format?.let {
                        Text(
                            color = TextColorUncheckedItemDreamGrid,
                            style = MaterialTheme.typography.caption,
                            text = "\$ $amount3Format",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                        )
                    }
                }
            }
            subtitle4?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        color = TextColorUncheckedItemDreamGrid,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.caption,
                        text = subtitle4,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                    )
                    amount4Format?.let {
                        Text(
                            color = TextColorUncheckedItemDreamGrid,
                            style = MaterialTheme.typography.caption,
                            text = "\$ $amount4Format",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                        )
                    }
                }
                Spacer(Modifier.height(dimensionResource(R.dimen.gap1)))
            }
        }
    }
}
