package com.example.planeando_suenos.framework.retrofit.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.response.smartShopping.*
import retrofit2.Response
import retrofit2.http.*

interface SmartShoppingApi {

    @GET("v1.0/dreamType")
    suspend fun getDreamsType(): Response<GetDreamsTypeResponse>

    @POST("v1.0/dreamPlan")
    suspend fun createDreamPlan(@Body dream: Dream): Response<SuccessDreamResponse>

    @PATCH("v1.0/dreamPlan")
    suspend fun updateDreamPlan(@Body dream: Dream): Response<SuccessDreamResponse>

    @GET("v1.0/dreamPlan")
    suspend fun getAllDreamsPlan(): Response<GetAllDreamsPlanResponse>

    @GET("v1.0/dreamPlan/{dreamPlanId}")
    suspend fun getDreamById(@Path("dreamPlanId") dreamPlanId: String): Response<GetDreamByIdResponse>
}