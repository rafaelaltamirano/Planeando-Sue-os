package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser

interface SmartShoppingDao {

    suspend fun getDreamsType(): List<DreamType>
    suspend fun createDreamPlan(dream: DreamPlan?)
    suspend fun updateDreamPlan(dream : DreamPlan)
    suspend fun getAllDreamsPlan(): DreamWithUser
    suspend fun getDreamById(dreamId: String): DreamWithUser
}