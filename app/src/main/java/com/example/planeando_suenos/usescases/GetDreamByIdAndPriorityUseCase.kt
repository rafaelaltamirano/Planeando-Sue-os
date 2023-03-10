package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import javax.inject.Inject

class GetDreamByIdAndPriorityUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend fun getDreamById(dreamId: String, priority: String): DreamWithUser {
        return smartShoppingDao.getDreamById(dreamId, priority)
    }

    suspend fun getDreamPlanCalendar(dreamId: String): List<DreamCalendarItem> {
        return smartShoppingDao.getDreamPlanCalendar(dreamId)
    }

    suspend fun updateDream(dream: DreamPlan) {
        return smartShoppingDao.updateDreamPlan(dream)
    }

    suspend fun sendDreamPlanEmail(dreamId: String) {
        return smartShoppingDao.sendDreamPlanEmail(dreamId)
    }

}