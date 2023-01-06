package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser
import javax.inject.Inject

class ApproximateIncomeUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend fun updateDream(dream: DreamPlan) {
        return smartShoppingDao.updateDreamPlan(dream)
    }
}
