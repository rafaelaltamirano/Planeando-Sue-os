package com.example.planeando_suenos.ui.screens.home.step1.dreamPlan

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TextDate
import com.example.planeando_suenos.ui.screens.home.step1.DreamsAndAspirationsViewModel
import com.example.planeando_suenos.ui.screens.utils.convertDateToFormat
import com.example.planeando_suenos.ui.theme.BackgroundItemDream
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.TextColorItemDream
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun DreamPlanStep(
    model: DreamsAndAspirationsViewModel,
    onFinish: () -> Unit
) {

    val itemDreams = model.state.dreamData?.dream?.mapNotNull { it.description }
    val dreamListData = model.state.dreamData?.dream?.toMutableList()
    val decimalPatter = remember { Regex("^\\d*\\.?\\d*\$") }
    lateinit var dreamPlan: DreamPlan

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        BoxDream(itemDreams)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "¿Cuánto dinero necesitas?", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 38.sp
            )
        )
        itemDreams?.forEachIndexed { index, string ->
            if (index == itemDreams.lastIndex) {
                AmountDream(
                    dream = string,
                    onDone = true,
                    value =
                    if (model.state.dreamData?.dream?.get(index)?.amount != null) {
                        model.state.dreamData?.dream?.get(index)?.amount.toString()
                    } else "",
                    onValueChanged = {
                        if (it.isEmpty() || it.matches(decimalPatter)) {
                            val dreamUpdate = dreamListData?.get(index)?.copy(amount = it.toFloat())
                            dreamListData?.set(index, dreamUpdate!!)
                            dreamPlan = DreamPlan(dream = dreamListData)
                            model.setDreamData(dreamPlan)
                        }
                    }

                )
            } else AmountDream(
                dream = string,
                value = if (model.state.dreamData?.dream?.get(index)?.amount != null) {
                    model.state.dreamData?.dream?.get(index)?.amount.toString()
                } else "",
                onValueChanged = {
                    if (it.isEmpty() || it.matches(decimalPatter)) {
                        val dreamUpdate = dreamListData?.get(index)?.copy(amount = it.toFloat())
                        dreamListData?.set(index, dreamUpdate!!)
                        dreamPlan = DreamPlan(dream = dreamListData)
                        model.setDreamData(dreamPlan)
                    }
                })
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
        TextDate(
            onValueChanged = { date ->
                dreamPlan = DreamPlan(dream = dreamListData?.map {
                    it.copy(
                        endDate = date,
                        startDate = Calendar.getInstance().time.convertDateToFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    )
                }
                )
                model.setDreamData(dreamPlan)
            })

        val amountFilled = model.state.dreamData?.dream!!.mapNotNull { it.amount }
        val endDateFilled = model.state.dreamData?.dream!!.mapNotNull { it.endDate }
        SubmitButton(
            text = stringResource(R.string.finalize),
            loading = model.state.loading,
            enabled = (model.state.dreamData?.dream!!.size == amountFilled.size)
                    && (model.state.dreamData?.dream!!.size == endDateFilled.size),
            onClick = {
                onFinish()

            }
        )
    }

}

@Composable
fun BoxDream(itemDreams: List<String>?) {
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
        itemDreams?.forEach {
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
fun AmountDream(
    dream: String,
    onDone: Boolean = false,
    value: String,
    onValueChanged: (String) -> Unit
) {

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
            onValueChanged = onValueChanged,
            placeholder = R.string.put_amount,
            keyboardType = KeyboardType.Number,
            modifier = Modifier.fillMaxWidth(),
            onDone = onDone
        )
    }
}

