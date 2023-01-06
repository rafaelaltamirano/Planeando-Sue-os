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
