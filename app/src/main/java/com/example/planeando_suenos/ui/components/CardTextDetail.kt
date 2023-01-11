package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.CardUnchecked


@Composable
fun CardTextDetail(title: String?, onPress: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.gap4),
                vertical = dimensionResource(id = R.dimen.gap3)
            )
            .clickable {
                onPress()
            },
    ){
        Row (
            modifier = Modifier
                .height(72.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(CardUnchecked)
                .padding(horizontal = dimensionResource(id = R.dimen.gap4)),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = title ?: "",
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(24.dp)
                    .fillMaxHeight()
            ) {
               Icon(
                    painter = painterResource(R.drawable.ic_arrow_next),
                    contentDescription = "next",
                    tint = Accent
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCardTextDetail(){
    CardTextDetail(title = "Test") {

    }
}