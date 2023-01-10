package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.BottomGreenGradient
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TopGreenGradient


@Composable
fun DreamPromotionCardItem(
    topGradientColor : Color,
    bottomGradientColor: Color,
){
    Box(
        modifier = Modifier
            .height(191.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
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
                    text = "Con Crédito Elektra consigue cumplir tu sueño en simples pasos.",
                    color = Color.White,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.gap5)
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDreamPromotionCardItem() {
    DreamPromotionCardItem(
        topGradientColor = TopGreenGradient, bottomGradientColor = BottomGreenGradient
    )
}