package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import javax.inject.Inject


class DreamAndAspirationUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend fun createDreamPlan(dream: DreamPlan?) {
        return smartShoppingDao.createDreamPlan(dream)
    }


    suspend fun getDreamType(): List<DreamType> {
        return smartShoppingDao.getDreamsType()
    }
}
