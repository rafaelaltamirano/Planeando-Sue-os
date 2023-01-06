package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem

interface SmartShoppingDao {

    suspend fun getDreamsType(): List<DreamType>
    suspend fun createDreamPlan(dream: DreamPlan?):String
    suspend fun updateDreamPlan(dream : DreamPlan)
    suspend fun getAllDreamsPlan(): DreamWithUser
    suspend fun getDreamById(dreamId: String): DreamWithUser
    suspend fun getDreamPlanCalendar(dreamId: String): List<DreamCalendarItem>
}