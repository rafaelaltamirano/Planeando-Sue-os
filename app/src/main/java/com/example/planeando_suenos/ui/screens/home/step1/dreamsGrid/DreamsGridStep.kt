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
import com.example.planeando_suenos.domain.body.smartShopping.DreamBody
import com.example.planeando_suenos.domain.body.smartShopping.DreamDataBody
import com.example.planeando_suenos.domain.entities.Dream
import com.example.planeando_suenos.domain.entities.DreamPlan
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step1.DreamsAndAspirationsViewModel
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid

enum class DreamType(val description:String){
    UNDERTAKE("Emprender o crecer mi negocio"),
    WHITE_LINE("Línea Blanca"),
    GADGET_AND_TECH("Gadget y electrónica"),
    NEW_TEAM_WORK("Nuevo equipo de trabajo"),
    BUILD_FUTURE_EDUCATION("Construir un futuro / educación"),
    NEW_SCREEN("Nueva Pantalla"),
    REMODEL_CONSTRUCTION("Remodelar y/o construcción"),
    FURNISH("Amueblar"),
    CHANGE_MOBILE("Cambiar de celular"),
    FAMILIAR_GIF("Regalo a un familiar"),
    VACATION("Ir de vacaciones"),
    VIDEO_GAMES_CONSOLE("Consola y Videojuegos"),
    EVENT_EXPERIENCE("Un Evento o Una nueva Experiencia"),
    APPLIANCE("Electrodomésticos"),
    CAR_MOTORCYCLE("Auto / Moto"),
    OTHER("Otros");
}


@Composable
fun DreamsGridStep(
    onNext: () -> Unit,
    model: DreamsAndAspirationsViewModel
) {
    lateinit var dreamBody: DreamBody
    val dreamListData = mutableListOf<DreamDataBody>()


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
                DreamItemGrid(
                    title = DreamType.UNDERTAKE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.UNDERTAKE.description))

                    }
                )
                DreamItemGrid(title = DreamType.WHITE_LINE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.WHITE_LINE.description))

                    })
                DreamItemGrid(title = DreamType.GADGET_AND_TECH.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.GADGET_AND_TECH.description))

                    })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(
                    title = DreamType.NEW_TEAM_WORK.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.NEW_TEAM_WORK.description))

                    })
                DreamItemGrid(title = DreamType.BUILD_FUTURE_EDUCATION.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.BUILD_FUTURE_EDUCATION.description))

                })
                DreamItemGrid(title = DreamType.NEW_SCREEN.description,
                    modifier = Modifier.weight(1f)
                    ,onClick = {
                    dreamListData.add(DreamDataBody(description = DreamType.NEW_SCREEN.description))

                })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = DreamType.REMODEL_CONSTRUCTION.description,
                    Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.REMODEL_CONSTRUCTION.description))

                    }
                )
                DreamItemGrid(
                    title = DreamType.FURNISH.description,
                    modifier =  Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.FURNISH.description))

                    })
                DreamItemGrid(title = DreamType.CHANGE_MOBILE.description,
                    modifier =  Modifier.weight(1f),
                    onClick = {
                    dreamListData.add(DreamDataBody(description = DreamType.CHANGE_MOBILE.description))

                })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title = DreamType.FAMILIAR_GIF.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                    dreamListData.add(DreamDataBody(description = DreamType.FAMILIAR_GIF.description))
                })
                DreamItemGrid(
                    title = DreamType.VACATION.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.VACATION.description))

                    })
                DreamItemGrid(title = DreamType.VIDEO_GAMES_CONSOLE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.VIDEO_GAMES_CONSOLE.description))

                    })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title =  DreamType.EVENT_EXPERIENCE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.EVENT_EXPERIENCE.description))

                    })
                DreamItemGrid(title = DreamType.APPLIANCE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.APPLIANCE.description))

                    })
                DreamItemGrid(title = DreamType.CAR_MOTORCYCLE.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.CAR_MOTORCYCLE.description))

                    })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DreamItemGrid(title =  DreamType.OTHER.description,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        dreamListData.add(DreamDataBody(description = DreamType.OTHER.description))

                    })

            }
        }

        SubmitButton(
            text = "continuar",
            onClick = {
                dreamBody = DreamBody(dream = dreamListData)
                model.setDreamData(dreamBody)
                onNext()
            }
        )
    }


}

@Composable
fun DreamItemGrid(title: String, modifier: Modifier, onClick: () -> Unit ) {
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
                if(checked) onClick()
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