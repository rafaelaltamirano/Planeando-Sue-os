package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import javax.inject.Inject

class GetDreamPlanCalendarUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend operator fun invoke(dreamId: String): List<DreamCalendarItem> {
        return smartShoppingDao.getDreamPlanCalendar(dreamId)
    }
}