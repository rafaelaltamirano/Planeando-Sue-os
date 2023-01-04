package com.example.planeando_suenos.ui.screens.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.convertDateToFormat(pattern:String): String {

    val formatter = SimpleDateFormat(pattern, Locale.getDefault())

    return formatter.format(this)
}