package com.example.planeando_suenos.ui.screens.home.step1.dreamPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TextDate
import com.example.planeando_suenos.ui.theme.BackgroundItemDream
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.TextColorItemDream

@Composable
fun DreamPlanStep(
    onFinish: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        BoxDream()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "¿Cuánto dinero necesitas?", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 38.sp
            )
        )
        itemDreams.forEachIndexed { index, string ->
            if (index == itemDreams.lastIndex) {
                AmountDream(string, true)
            } else AmountDream(string)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "¿Cuándo quieres cumplir tu sueño?", style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 38.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Selecciona una fecha", style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 23.sp
            )
        )
        TextDate()
        SubmitButton(
            text = "continuar",
            onClick = { onFinish() }
        )
    }

}

private val itemDreams = listOf(
    "Eventos Viajes",
    "Salud",
    "Linea blanca",
    "Nueva ropa"
)

@Composable
fun BoxDream() {
    val radius = RoundedCornerShape(6.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, GrayBusiness, radius)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = "¿Qué cosas ayudarían a cumplir tu sueño?",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        itemDreams.forEach {
            DreamItem(it)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun DreamItem(dream: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(BackgroundItemDream, RoundedCornerShape(30.dp))
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            text = dream,
            color = TextColorItemDream,
            fontSize = 13.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun AmountDream(dream: String, onDone: Boolean = false) {
    var value by rememberSaveable {
        mutableStateOf("")
    }
    Column(Modifier.padding(top = 24.dp)) {
        Text(
            text = dream, style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 23.sp
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            value = value,
            onValueChanged = { value = it },
            placeholder = com.example.planeando_suenos.R.string.put_amount,
            keyboardType = KeyboardType.Number,
            modifier = Modifier.fillMaxWidth(),
            onDone = onDone
        )
    }
}

