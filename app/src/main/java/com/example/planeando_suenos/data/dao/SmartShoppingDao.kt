package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.smartShopping.DreamBody
import com.example.planeando_suenos.domain.entities.DreamPlan
import com.example.planeando_suenos.domain.entities.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser

interface SmartShoppingDao {

    suspend fun getDreamsType(): DreamType
    suspend fun createDreamPlan(dream: DreamBody?)
    suspend fun updateDreamPlan(dream : DreamPlan)
    suspend fun getAllDreamsPlan(): DreamWithUser
    suspend fun getDreamById(dreamId: String): DreamWithUser
}