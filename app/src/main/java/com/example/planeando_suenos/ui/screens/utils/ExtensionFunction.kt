package com.example.planeando_suenos.ui.screens.utils

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun Date.convertDateToFormat(pattern:String): String {

    val formatter = SimpleDateFormat(pattern, Locale.getDefault())

    return formatter.format(this)
}

fun Double.ceilRound(): Int {
    return DecimalFormat("#").apply {
        roundingMode = RoundingMode.CEILING
    }.format(this).toInt()
}

fun String.toDateString(pattern: String = "dd/MM/yyyy"): String {
    val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.getDefault())
    val dateFormatIso = isoFormat.parse(this)
    val sdf = SimpleDateFormat(pattern, Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    return sdf.format(dateFormatIso!!)
}

fun String.toDate(): Date? {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.getDefault())
    return sdf.parse(this)

}
