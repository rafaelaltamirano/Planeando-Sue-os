package com.example.planeando_suenos.ui.components


import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.BackgroundCard
import com.example.planeando_suenos.ui.theme.GreenBusiness
import java.text.SimpleDateFormat
import java.util.*

private val mCalendar: Calendar = Calendar.getInstance()

@Composable
fun TextDate( onValueChanged: (String) -> Unit) {
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
            onValueChanged(date)
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
        Text(
            text = date,
            style = MaterialTheme.typography.caption, modifier = Modifier.padding(
                vertical = dimensionResource(
                    R.dimen.gap4
                )
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Outlined.CalendarToday,
            contentDescription = "Calendar",
            tint = GreenBusiness
        )
    }
}