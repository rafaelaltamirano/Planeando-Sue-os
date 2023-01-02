package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.calendar

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithText
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import java.text.SimpleDateFormat
import java.util.*

private val first6Months = listOf("Ene", "Feb", "Mar", "Abr", "May", "Jun")
private val last6Months = listOf("Jul", "Ago", "Sep", "Oct", "Nov", "Dic")

@Composable
fun CalendarStep(
    onSubmit: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    )
    {
        TopBarWithText("Cronograma de pago")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Cronograma de pago",
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Arrastra y prioriza tu pago.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextColorUncheckedItemDreamGrid
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "2023",
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    color = TextColorUncheckedItemDreamGrid,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
            RowMonths(first6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(
                        Color(0xFF0071BC),
                        RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(
                        Color(0xFF00C851),
                        RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp)
                    )
            )
            RowMonths(last6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(
                        Color(0xFF0071BC),
                        RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .fillMaxHeight()
                        .background(
                            Color(0xFF00C851),
                            RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "2024",
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    color = TextColorUncheckedItemDreamGrid,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
            RowMonths(first6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(230.dp)
                        .background(
                            Color(0xFF0071BC),
                            RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(vertical = 4.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(
                        Color(0xFFF5F5F5),
                        RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
                    )
            )
            RowMonths(last6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "2025",
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    color = TextColorUncheckedItemDreamGrid,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
            RowMonths(first6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            )
            RowMonths(last6Months)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            SubmitButton(onClick = {
                onSubmit()
            }, text = "guardar plan")
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

private data class DreamCalendarItem(
    val dateInit: String,
    val dateFinish: String,
    val color: Color,
    val id: String
)

private val dateDreams = listOf(
    DreamCalendarItem("02/2023", "04/2023", Color.Blue, "dream2"),
    DreamCalendarItem("01/2023", "08/2023", Color.Green, "dream1"),
)

private val calendar = Calendar.getInstance()

private fun isInThisMonth(actualDate: Date, itemDate: Date): Boolean {
    return actualDate.before(itemDate)
}

@Composable
fun CalendarPerYear(year: String) {

    val dateFormat = SimpleDateFormat("MM/yyyy", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = year,
            modifier = Modifier.align(Alignment.End),
            style = TextStyle(
                color = TextColorUncheckedItemDreamGrid,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        )
        RowMonths(listMonths = first6Months)
        dateDreams.forEach { dream ->
            val dateInit = dateFormat.parse(dream.dateInit)
            val dateFinish = dateFormat.parse(dream.dateFinish)
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(),horizontalArrangement = Arrangement.SpaceAround) {
                repeat(6) {
                    if (isInThisMonth(dateInit, dateFinish)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp)
                                .background(dream.color)
                        )

                    } else Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(25.dp)
                            .background(
                                TextColorUncheckedItemDreamGrid
                            )
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevCalendarDream() {
    CalendarPerYear("2023")
}