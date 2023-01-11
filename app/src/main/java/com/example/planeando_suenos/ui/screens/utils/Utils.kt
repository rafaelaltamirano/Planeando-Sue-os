package com.example.planeando_suenos.ui.screens.utils

import androidx.compose.runtime.mutableStateListOf
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.entities.Categories
import java.text.SimpleDateFormat
import java.util.*

fun getWeeksFromDates(startDate:String?, endDate:String?): Int {
    if(startDate==null && endDate==null )return 0
    val dateFormatter =  SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
//    val from = dateFormatter.parse(startDate)
//    val to = dateFormatter.parse(endDate)
    val from = startDate?.toDate()
    val to = endDate?.toDate()
    val mDifference = kotlin.math.abs((from?.time ?: 0) - (to?.time ?: 0))

    // Converting milli seconds to dates
    val daysDifference = mDifference / (24 * 60 * 60 * 1000)

    // Converting the above integer to string
    val weeksDifference = daysDifference / 7

    return weeksDifference.toInt()
}


fun getCategoryList(dream: List<Dream>?): List<Categories> {
    val group = dream?.groupBy { it.dreamType?.category }
    val categories = mutableStateListOf<Categories>()

    group?.map { (category, dream) ->
        val title = category?.title
        val totalAmountPlaned = dream.mapNotNull { it.amountPlaned }.sum()
        val percentage = category?.interestRatePercentage
        val weeks = dream.map {getWeeksFromDates(it.startDate,it.endDate)}.maxOrNull()
        categories.add(Categories(title, totalAmountPlaned, weeks, percentage))
    }
    return categories.toList()
}