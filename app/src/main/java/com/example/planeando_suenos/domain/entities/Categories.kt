package com.example.planeando_suenos.domain.entities

import java.time.temporal.TemporalAmount


data class Categories(
    val title: String? = null,
    val totalAmount: Float?= null,
    val period: Int? = null,
    val porcentage: Float? = null
)