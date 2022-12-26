package com.example.planeando_suenos.ui.screens.home.step1.dreamPlan

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

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
        itemDreams.forEach {
            AmountDream(it)
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
    "Salud, operarme los ojos, mejorarme los dientes",
    "Equipar hogar con pequeños electrodomésticos",
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
            text = "¿De qué tipo es tu sueño?",
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
fun AmountDream(dream: String) {
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
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private val mCalendar: Calendar = Calendar.getInstance()

@Composable
fun TextDate() {
    val hint: String = stringResource(id = com.example.planeando_suenos.R.string.date_example)

    var date by rememberSaveable {
        mutableStateOf(hint)
    }

    val mContext = LocalContext.current


    val mYear: Int = mCalendar.get(Calendar.YEAR)
    val mMonth: Int = mCalendar.get(Calendar.MONTH)
    val mDay: Int = mCalendar.get(Calendar.DAY_OF_MONTH)

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            mCalendar.apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, month)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }
            date = formatter.format(mCalendar.time)
        }, mYear, mMonth, mDay
    )


    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(BackgroundCard, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp)
            .clickable {
                mDatePickerDialog.show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = date, style = MaterialTheme.typography.caption, modifier = Modifier.padding(vertical = dimensionResource(
            R.dimen.gap4)))
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Outlined.CalendarToday,
            contentDescription = "Calendar",
            tint = GreenBusiness
        )
    }
}