package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.DreamBody
import javax.inject.Inject


class DreamAndAspirationUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend fun createDreamPlan(dream: DreamBody?) {
        return smartShoppingDao.createDreamPlan(dream)
    }
}
