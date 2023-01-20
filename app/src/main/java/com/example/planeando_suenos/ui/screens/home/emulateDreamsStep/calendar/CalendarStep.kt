package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.calendar

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import com.example.planeando_suenos.domain.response.smartShopping.DreamItem
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithText
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.BackgroundUncheckedItemDreamGrid
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid

private val first6Months = listOf("Ene", "Feb", "Mar", "Abr", "May", "Jun")
private val last6Months = listOf("Jul", "Ago", "Sep", "Oct", "Nov", "Dic")

@Composable
fun CalendarStep(
    model: EmulateDreamsViewModel,
    dreamId: String,
    onSubmit: () -> Unit,
    onBack: () -> Unit
) {

    LaunchedEffect(Unit) {
        model.getDreamCalendar(dreamId)
    }

    if (model.state.loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Visualiza tu pago.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextColorUncheckedItemDreamGrid
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                model.state.dreamsCalendarItem.forEach {
                    CalendarPerYear(dreamCalendarItem = it)
                    Spacer(modifier = Modifier.height(4.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                SubmitButton(
                    text = "continuar",
                    loading = model.state.loading,
                    onClick = onSubmit
                   )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Volver",
                    style = TextStyle(
                        color = Color(0xFF9D4BEB),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            onBack()
                        }
                )
            }
        }
    }

}

@Composable
fun RowMonths(listMonths: List<String>) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        listMonths.forEach {
            Text(
                text = it.uppercase(),
                style = TextStyle(
                    color = TextColorUncheckedItemDreamGrid,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CalendarPerYear(dreamCalendarItem: DreamCalendarItem) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
            .padding(8.dp)
    ) {

        Text(
            text = dreamCalendarItem.year.toString(),
            modifier = Modifier.align(Alignment.End),
            style = TextStyle(
                color = TextColorUncheckedItemDreamGrid,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        )

        RowMonths(listMonths = first6Months)

        if (dreamCalendarItem.eneJun.isEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(BackgroundUncheckedItemDreamGrid, RoundedCornerShape(4.dp))
                )
            }
        }

        dreamCalendarItem.eneJun.forEach {
            PaintMonths(it)
            Spacer(modifier = Modifier.height(4.dp))
        }

        RowMonths(listMonths = last6Months)

        if (dreamCalendarItem.julDic.isEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(BackgroundUncheckedItemDreamGrid, RoundedCornerShape(4.dp))
                )
            }
        }

        dreamCalendarItem.julDic.forEach {
            PaintMonths(it)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

}

@Composable
private fun PaintMonths(item: DreamItem) {

    if (item.monthInit < 7) {
        RowMonthEneJunPaint(
            monthInit = item.monthInit,
            monthFinish = item.monthFinish,
            color = try {
                Color(item.color.toColorInt())
            }
            catch (e:Exception){
                GreenBusiness
            }
        )
    } else {
        RowMonthJulDicPaint(
            monthInit = item.monthInit,
            monthFinish = item.monthFinish,
            color = try {
                Color(item.color.toColorInt())
            }
            catch (e:Exception){
                GreenBusiness
            }
        )
    }
}

@Composable
fun RowMonthEneJunPaint(monthInit: Int, monthFinish: Int, color: Color) {
    try{
        require(monthFinish in 1..6)

    }
    catch (e: Exception){
        throw e
    }
    val rest = 6 - monthFinish
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    {
        for (grayBox in 2..monthInit) {
            val shape = if (grayBox == 2) {
                RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
            } else RectangleShape

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
                    .background(BackgroundUncheckedItemDreamGrid, shape)
            )
        }

        for (colorBox in monthInit..monthFinish) {
            var shape = RectangleShape
            if (monthInit == colorBox) {
                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
            }
            if (monthFinish == colorBox) {
                shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
            }
            if (monthInit == monthFinish) {
                shape = RoundedCornerShape(4.dp)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
                    .background(color, shape)
            )
        }

        if (rest > 0) {
            repeat(rest) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(25.dp)
                        .background(
                            BackgroundUncheckedItemDreamGrid,
                            if (rest - 1 == it)
                                RoundedCornerShape(
                                    topEnd = 4.dp,
                                    bottomEnd = 4.dp
                                ) else RectangleShape
                        )
                )
            }
        }
    }
}

@Composable
fun RowMonthJulDicPaint(monthInit: Int, monthFinish: Int, color: Color) {
    require(monthFinish in 7..12)
    val rest = 12 - monthFinish
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    {
        for (grayBox in 8..monthInit) {
            val shape = if (grayBox == 8) {
                RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
            } else RectangleShape
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
                    .background(BackgroundUncheckedItemDreamGrid, shape)
            )
        }

        for (colorBox in monthInit..monthFinish) {
            var shape = RectangleShape
            if (monthInit == colorBox) {
                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
            }
            if (monthFinish == colorBox) {
                shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
            }
            if (monthInit == monthFinish) {
                shape = RoundedCornerShape(4.dp)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
                    .background(color, shape)
            )
        }

        if (rest > 0) {
            repeat(rest) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(25.dp)
                        .background(
                            BackgroundUncheckedItemDreamGrid,
                            if (rest - 1 == it)
                                RoundedCornerShape(
                                    topEnd = 4.dp,
                                    bottomEnd = 4.dp
                                ) else RectangleShape
                        )
                )
            }
        }
    }
}