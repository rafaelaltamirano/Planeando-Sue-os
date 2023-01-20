package com.example.planeando_suenos.ui.screens.utils

import androidx.compose.runtime.mutableStateListOf
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.entities.Categories
import com.example.planeando_suenos.domain.entities.DreamWithUser
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil
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

fun getCategoryList(dreamPlan: DreamWithUser?): List<Categories> {

    val dream = dreamPlan?.dream
    val group = dream?.groupBy { it.dreamType?.category }
    val categories = mutableStateListOf<Categories>()
    val paymentCapability = dreamPlan?.userFinance?.paymentCapability ?: 0f

    group?.map { (category, dreams) ->
        val percentage = category?.interestRatePercentage?.div(100) ?: 0f
        val totalAmountPlaned = dreams.mapNotNull { it.amountPlaned }.sum()

        val title = category?.title
        val maxPaymentQuantity = dreams.maxOf { it.paymentQuantity ?: 0f }// A
        val weekFrom = ceil(maxPaymentQuantity.toDouble()).toInt()// X
        val amountWeekTo = ((totalAmountPlaned * percentage / 52) / (1 - (1 + (percentage) / 52).pow(-maxPaymentQuantity))) // Y
        val weekTo = ceil((amountWeekTo * maxPaymentQuantity / paymentCapability)).toInt()//B
        val bigDecimal = BigDecimal((amountWeekTo * maxPaymentQuantity).toDouble())
        val roundOff = bigDecimal.setScale(2, RoundingMode.CEILING)
        val amountToPay = roundOff.toFloat()

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