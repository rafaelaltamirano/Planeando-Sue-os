package com.example.planeando_suenos.framework.datasource

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.framework.api.ApiTools
import com.example.planeando_suenos.framework.retrofit.smartShopping.SmartShoppingApi
import javax.inject.Inject


class SmartShoppingDaoImp @Inject constructor(
    private val smartShoppingApi: SmartShoppingApi
) : SmartShoppingDao {

    override suspend fun getDreamsType(): List<DreamType> {

        val res = smartShoppingApi.getDreamsType()
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.map { it.toEntity() }
    }

    override suspend fun createDreamPlan(dream: com.example.planeando_suenos.domain.body.smartShopping.DreamPlan?) {
        val res = smartShoppingApi.createDreamPlan(dream)
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun updateDreamPlan(dream: DreamPlan) {
        val res = smartShoppingApi.updateDreamPlan(dream)
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun getAllDreamsPlan(): DreamWithUser {
        val res = smartShoppingApi.getAllDreamsPlan()
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.toEntity()
    }

    override suspend fun getDreamById(dreamId: String): DreamWithUser {
        val res = smartShoppingApi.getDreamById(dreamId)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.toEntity()
    }


}
