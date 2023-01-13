package com.example.planeando_suenos.ui.screens.utils

import androidx.compose.runtime.mutableStateListOf
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.entities.Categories
import com.example.planeando_suenos.domain.entities.DreamWithUser
import kotlin.math.pow

// RETORNA LA CANTIDAD DE SEMANAS ENTRE DOS FECHAS
fun getWeeksFromDates(startDate: String?, endDate: String?): Int {
    if (startDate == null && endDate == null) return 0
    val from = startDate?.toDate()
    val to = endDate?.toDate()
    val mDifference = kotlin.math.abs((from?.time ?: 0) - (to?.time ?: 0))

    // Converting milli seconds to dates
    val daysDifference = mDifference / (24 * 60 * 60 * 1000)

    // Converting the above integer to string
    val weeksDifference = daysDifference / 7

    return weeksDifference.toInt()
}

// FORMA DE OBTENER LAS SEMANALIDADES Y PLAZOS CUANDO SOLO PEDIAN UN DATO
//fun getCategoryList(dream: List<Dream>?): List<Categories> {
//    val group = dream?.groupBy { it.dreamType?.category }
//    val categories = mutableStateListOf<Categories>()
//
//    group?.map { (category, dream) ->
//        val title = category?.title
//        val totalAmountPlaned = dream.mapNotNull { it.amountPlaned }.sum()
//        val percentage = category?.interestRatePercentage
//        val weeks = dream.map { getWeeksFromDates(it.startDate, it.endDate) }.maxOrNull()
//        categories.add(Categories(title, totalAmountPlaned, weeks, percentage))
//    }
//    return categories.toList()
//}

fun getCategoryList(dreamPlan: DreamWithUser?): List<Categories> {

    val dream = dreamPlan?.dream
    val group = dream?.groupBy { it.dreamType?.category }
    val categories = mutableStateListOf<Categories>()
    val paymentCapability = dreamPlan?.userFinance?.paymentCapability ?: 0f

    group?.map { (category, dreams) ->
        val percentage = category?.interestRatePercentage ?: 0f
        val totalAmountPlaned = dreams.mapNotNull { it.amountPlaned }.sum()

        val title = category?.title
        val maxPaymentQuantity = dreams.maxOf { it.paymentQuantity ?: 0f }// A
        val weekFrom = dreamPlan.userFinance?.paymentCapability?.toInt()// X
        val amountWeekTo = ((totalAmountPlaned * percentage / 52) / (1 - (1 + (percentage) / 52).pow(maxPaymentQuantity))) // Y
        val weekTo = (amountWeekTo * maxPaymentQuantity / paymentCapability).toInt()//B
        val amountToPay = amountWeekTo * maxPaymentQuantity

        categories.add(
            Categories(
                title = title,
                weekFrom = weekFrom,
                weekTo = weekTo,
                amountWeekFrom = maxPaymentQuantity,
                amountWeekTo = amountWeekTo,
                amountToPay = amountToPay
            )
        )
    }
    return categories.toList()
}