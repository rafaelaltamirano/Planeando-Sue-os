package com.example.planeando_suenos.ui.screens.home.step1.dreamsGrid

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step1.DreamsAndAspirationsViewModel
import com.example.planeando_suenos.ui.screens.utils.ceilRound
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil


@Composable
fun DreamsGridStep(
    onNext: () -> Unit,
    model: DreamsAndAspirationsViewModel
) {
    lateinit var dreamPlan: DreamPlan
    val dreamListData = remember { mutableStateListOf<Dream>() }
    val otherMark = remember { mutableStateOf(false) }
    val otherTitle = remember { mutableStateOf("") }
    var idOtro: String? = null

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

        if (model.state.loading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    color = Accent
                )
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                var totalItem = model.state.dreamTypes.size
                val totalRows = (totalItem.toDouble() / 3).ceilRound()
                var itemCount = 0

                for (n in 0 until totalRows) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        for (i in 1..3) {
                            if (totalItem != 0) {
                                DreamItemGrid(
                                    title = model.state.dreamTypes[itemCount].title ?: "",
                                    imageName = model.state.dreamTypes[itemCount].iconName ?: "",
                                    modifier = Modifier.weight(1f),
                                    onClick = {
                                        //SI ES OTRO GUARDO ACTIVO LA MARCA
                                        if (model.state.dreamTypes[((3 * n) + i) - 1].title == "Otro") {
                                            idOtro = model.state.dreamTypes[((3 * n) + i) - 1].id
                                            otherMark.value = true
                                        } else {
                                            // CASO CONTRARIO CARGO DIRECTAMENTE LA LISTA
                                            //((3*n)+i)-1 = FORMULA PARA OBTENER POSICION
                                            dreamListData.add(
                                                Dream(
                                                    description = model.state.dreamTypes[((3 * n) + i) - 1].title ?: "",
                                                    dreamType = DreamType(id = model.state.dreamTypes[((3 * n) + i) - 1].id)
                                                )
                                            )
                                        }
                                    },
                                    onClear = {
                                        //BORRO LA MARCA EN CASO DE SER OTRO O BORRO EL CONTENIDO SI ES DISTINTO
                                        if (model.state.dreamTypes[((3 * n) + i) - 1].title == "Otro") {
                                            otherMark.value = false
                                        } else {
                                            dreamListData.removeIf { dream -> dream.dreamType?.id == model.state.dreamTypes[((3 * n) + i) - 1].id }
                                        }
                                    }
                                )
                                totalItem -= 1
                            }
                            itemCount += 1
                        }
                    }
                }
            }
        }

        if (otherMark.value) {
            Text(
                modifier = Modifier.padding(top = dimensionResource(R.dimen.gap4)),
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontSize = 17.sp,
                text = stringResource(R.string.enter_description)
            )
            CustomTextField(
                value = otherTitle.value,
                placeholder = R.string.dog_terapy,
                onDone = true,
                onValueChanged = { otherTitle.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.gap3))
            )
        }

        SubmitButton(
            text = stringResource(R.string.continue_),
            enabled = dreamListData.isNotEmpty() || otherTitle.value != "" ,
            onClick = {
                //SI ES OTRO SE VA A CARGAR A LA LISTA SOLO AL HACER CLICK EN CONTINUAR
                if(otherMark.value){
                    dreamListData.add(
                        Dream(description = otherTitle.value,
                             dreamType = DreamType(id = idOtro)))
                }
                dreamPlan = DreamPlan(dream = dreamListData)
                model.setDreamData(dreamPlan)
                onNext()
            }
        )
    }

}

@Composable
fun DreamItemGrid(
    title: String,
    imageName: String,
    modifier: Modifier,
    onClick: () -> Unit,
    onClear: () -> Unit
) {
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
                if (checked) onClick()
                if (!checked) onClear()
            }
    ) {
        Text(
            text = title,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp)
        )
        if (imageName != "" && imageName != "otro") {
            Icon(
                painter = painterResource(getImage(imageName)),
                contentDescription = "",
                tint = textColor,
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 8.dp)
            )
        }
    }
}


fun getImage(name: String): Int {
    return when (name) {
        "business" -> R.drawable.ic_negocio_ic
        "lineaBlanca" -> R.drawable.ic_lineablanca_ic
        "electro" -> R.drawable.ic_electronica_ic
        "tool" -> R.drawable.ic_taladro_ic
        "toga" -> R.drawable.ic_estudio_ic
        "tv" -> R.drawable.ic_pntalla_ic
        "bloques" -> R.drawable.ic_construccion_ic
        "sofa" -> R.drawable.ic_mueble_ic
        "celular" -> R.drawable.ic_phone_ic
        "regalo" -> R.drawable.ic_regalo_ic
        "celular" -> R.drawable.ic_phone_ic
        "vacaciones" -> R.drawable.ic_vacaciones_ic
        "control" -> R.drawable.ic_gmae_ic
        "torta" -> R.drawable.ic_cumple_ic
        "rueda" -> R.drawable.ic_movilidad_ic
        "batidora" -> R.drawable.ic_batidora
        else -> {
            R.drawable.ic_batidora
        }
    }
}