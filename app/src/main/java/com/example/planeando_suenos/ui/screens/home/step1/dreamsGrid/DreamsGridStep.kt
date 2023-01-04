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
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.step1.DreamsAndAspirationsViewModel
import com.example.planeando_suenos.ui.theme.Accent
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DreamsGridStep(
    onNext: () -> Unit,
    model: DreamsAndAspirationsViewModel
) {
    lateinit var dreamPlan: DreamPlan
    val dreamListData = remember {  mutableStateListOf<Dream>()}


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
                var clearPosition = 0

                for (n in 0 until totalRows) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        for (i in 1..3) {
                            if (totalItem != 0) {
                                DreamItemGrid(
                                    title = model.state.dreamTypes[itemCount].title ?: "",
                                    modifier = Modifier.weight(1f),
                                    onClick = {
                                        Log.d("TEST",((3*n)+i).toString())
                                        dreamListData.add(
//                                            ((3*n)+i)-1 = position formula
                                            Dream(
                                                description = model.state.dreamTypes[((3*n)+i)-1].title ?: "",
                                                dreamType = DreamType(
                                                    id = model.state.dreamTypes[((3*n)+i)-1].id
                                                )
                                            )
                                        )
                                        dreamListData.forEach{
                                            Log.d("TEST",it.toString())
                                        }

                                        clearPosition += 1
                                    },
                                    onClear = {
                                      dreamListData.removeIf { dream -> dream.dreamType?.id === model.state.dreamTypes[n].id }
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
            SubmitButton(
                text = stringResource(R.string.continue_),
                enabled = dreamListData.isNotEmpty(),
                onClick = {
                    dreamPlan = DreamPlan(dream = dreamListData)
                    model.setDreamData(dreamPlan)
                    onNext()
                }
            )
    }

}

@Composable
fun DreamItemGrid(title: String, modifier: Modifier, onClick: () -> Unit,onClear: () -> Unit) {
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
    }
}

fun Double.ceilRound(): Int {
    return DecimalFormat("#").apply {
        roundingMode = RoundingMode.CEILING
    }.format(this).toInt()
}

fun Double.roundCeil(): Int = ceil(this).toInt()
