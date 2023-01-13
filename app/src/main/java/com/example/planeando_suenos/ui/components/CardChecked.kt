package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.theme.CardUnchecked
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun CardChecked(
    checked: Boolean,
    enable:Boolean = true,
    title: String,
    subTitle: String,
    onClick: () -> Unit
) {

    val colorChecked = GreenBusiness
    val colorUnchecked = CardUnchecked
    val colorDisable = GrayBusiness

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(if(!enable)colorDisable else Color.Transparent)
            .border(1.dp, if (checked) colorChecked else colorUnchecked)
            .clickable { if(enable) onClick() },
        elevation = 5.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Row(modifier = Modifier.weight(0.2f)) {
                if (checked) {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "",
                        tint = colorChecked
                    )
                }
            }

            Column(Modifier.weight(if(checked)0.8f else 1f)) {
                Text(
                    text = title,
                    color = if(enable) colorChecked else colorDisable,
                    fontSize = if (checked) 14.sp else TextUnit.Unspecified,
                    fontWeight = FontWeight.Bold
                )
                if (checked) {
                    Text(
                        text = subTitle,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            if(enable) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = "",
                    tint = colorChecked
                )
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevCardChecked() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        CardChecked(true, enable = false,  "Tus sueños y aspiraciones", subTitle = "Datos completados con éxito") {}
        Spacer(modifier = Modifier.size(16.dp))
        CardChecked(false, enable = false,title = "Tus ingresos aproximados", subTitle = "$ 1.600.00 semanales") {}
        Spacer(modifier = Modifier.size(16.dp))
        CardChecked(false, title = "Tus gastos o créditos", subTitle =  "$ 861.40 semanales") {}
        Spacer(modifier = Modifier.size(16.dp))
    }
}