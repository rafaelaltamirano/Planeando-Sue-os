package com.example.planeando_suenos.ui.screens.home.step1.dreamsGrid

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid

@Composable
fun DreamsGridStep(
    onNext: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "¿Qué cosas ayudarían a cumplir tu sueño?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            lineHeight = 38.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = "Eventos Viajes", Modifier.weight(1f))
                DreamItemGrid(title = "Remodelar mi casa", Modifier.weight(1f))
                DreamItemGrid(title = "Comprar muebles nuevos", Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = "Nueva ropa", Modifier.weight(1f))
                DreamItemGrid(title = "Salud", Modifier.weight(1f))
                DreamItemGrid(title = "Tener mi moto", Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = "Hacer un regalo a un familiar", Modifier.weight(1f))
                DreamItemGrid(title = "Línea blanca", Modifier.weight(1f))
                DreamItemGrid(title = "Comprar mi computadora", Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = "Video juegos", Modifier.weight(1f))
                DreamItemGrid(title = "Cambiar mi celular", Modifier.weight(1f))
                DreamItemGrid(title = "Comprar lavadora", Modifier.weight(1f))
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = "Comprar refrigerador", Modifier.weight(1f))
                DreamItemGrid(title = "Comprar televisor", Modifier.weight(1f))
                DreamItemGrid(title = "Otro", Modifier.weight(1f))
            }
        }

        SubmitButton(
            text = "continuar",
            onClick = { onNext() }
        )
    }


}

@Composable
fun DreamItemGrid(title: String, modifier: Modifier) {
    var checked by remember { mutableStateOf(false) }

    val radius = RoundedCornerShape(6.dp)

    val backgroundColor = if (checked) Accent else BackgroundUncheckedItemDreamGrid
    val textColor = if (checked) Color.White else TextColorUncheckedItemDreamGrid

    Box(
        modifier = modifier
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