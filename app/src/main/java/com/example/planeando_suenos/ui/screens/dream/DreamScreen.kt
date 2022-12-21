package com.example.planeando_suenos.ui.screens.dream

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid

@Composable
fun DreamScreen() {

    DreamContent()

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevDreamScreen() {
    DreamContent()
}

val dreamList = listOf(
    "Eventos Viajes",
    "Remodelar mi casa",
    "Comprar muebles nuevos",
    "Nueva ropa",
    "Salud, operarme los ojos, mejorarme los dientes ",
    "Tener mi moto",
    "Nueva tele / refrigerador/ Lavadora",
    "Equipar hogar con pequeños electrodomésticos",
    "Comprar mi computadora",
    "Video juegos",
    "Cambiar mi celular",
    "Hacer un regalo a un familiar",
    "Otro"
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DreamContent() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "¿De qué tipo es tu sueño?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            lineHeight = 38.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(dreamList) {
                DreamItemGrid(it)
            }
        }
    }

}

@Composable
fun DreamItemGrid(title: String) {
    var checked by remember { mutableStateOf(false) }

    val radius = RoundedCornerShape(6.dp)

    val backgroundColor = if (checked) GreenBusiness else BackgroundUncheckedItemDreamGrid
    val textColor = if (checked) Color.White else TextColorUncheckedItemDreamGrid

    Box(
        modifier = Modifier
            .size(100.dp, 120.dp)
            .clip(radius)
            .background(backgroundColor, radius)
            .clickable {
                checked = !checked
            }
    ) {
        Text(
            text = title,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp)
        )
    }
}