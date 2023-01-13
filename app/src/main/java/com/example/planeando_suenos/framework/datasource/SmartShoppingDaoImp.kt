package com.example.planeando_suenos.framework.datasource

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
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

    override suspend fun createDreamPlan(dream: DreamPlan?): String {
        val res = smartShoppingApi.createDreamPlan(dream)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data
    }

    override suspend fun updateDreamPlan(dream: DreamPlan) {
        val res = smartShoppingApi.updateDreamPlan(dream)
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun getAllDreamsPlan(): List<DreamWithUser> {
        val res = smartShoppingApi.getAllDreamsPlan()
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.map{it.toEntity()}
    }

    override suspend fun getDreamById(dreamId: String, priority: String): DreamWithUser {
        val res = smartShoppingApi.getDreamById(dreamId, priority)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.toEntity()
    }

    override suspend fun getDreamPlanCalendar(dreamId: String): List<DreamCalendarItem> {
        val res = smartShoppingApi.getDreamPlanCalendar(dreamId)
        ApiTools.validateResponseOrFail(res)
        return res.body()?.data?.dreams.orEmpty()
    }

    override suspend fun sendDreamPlanEmail(dreamId: String) {
        val res = smartShoppingApi.sendDreamPlanEmail(dreamId)
        ApiTools.validateResponseOrFail(res)
    }

}
