package com.example.planeando_suenos.domain.entities


data class Categories(
    val title: String? = null,
    val weekFrom: Int?= null,
    val weekTo: Int?= null,
    val amountWeekFrom: Float?= null,
    val amountWeekTo: Float?= null,
    val amountToPay: Float?= null,
)