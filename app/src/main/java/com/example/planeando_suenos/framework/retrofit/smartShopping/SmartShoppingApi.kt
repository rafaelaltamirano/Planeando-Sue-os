package com.example.planeando_suenos.framework.retrofit.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.DreamBody
import com.example.planeando_suenos.domain.entities.DreamPlan
import com.example.planeando_suenos.domain.response.ResponseWrapper
import com.example.planeando_suenos.domain.response.smartShopping.CalendarResponse
import com.example.planeando_suenos.domain.response.smartShopping.DreamTypeResponse
import com.example.planeando_suenos.domain.response.smartShopping.DreamWithUserResponse
import retrofit2.Response
import retrofit2.http.*

interface SmartShoppingApi {

    @GET("v1.0/dreamType")
    suspend fun getDreamsType(): Response<ResponseWrapper<DreamTypeResponse>>

    @POST("v1.0/dreamPlan")
    suspend fun createDreamPlan(@Body dream: DreamBody?): Response<ResponseWrapper<Boolean>>

    @PATCH("v1.0/dreamPlan")
    suspend fun updateDreamPlan(@Body dream: DreamPlan):  Response<ResponseWrapper<Boolean>>

    @GET("v1.0/dreamPlan")
    suspend fun getAllDreamsPlan(): Response<DreamWithUserResponse>

    @GET("v1.0/dreamPlan/{dreamPlanId}")
    suspend fun getDreamById(@Path("dreamPlanId") dreamPlanId: String): Response<DreamWithUserResponse>

    @GET("v1.0/dreamPlan/calendar/{dreamPlanId}")
    suspend fun getDreamPlanCalendar(@Path("dreamPlanId") dreamPlanId: String): Response<CalendarResponse>
}