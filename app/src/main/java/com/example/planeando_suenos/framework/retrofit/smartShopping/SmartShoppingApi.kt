package com.example.planeando_suenos.framework.retrofit.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.response.ResponseData
import com.example.planeando_suenos.domain.response.ResponseWrapper
import com.example.planeando_suenos.domain.response.ResponseWrapperWithList
import com.example.planeando_suenos.domain.response.smartShopping.CalendarResponse
import com.example.planeando_suenos.domain.response.smartShopping.DreamTypeResponse
import com.example.planeando_suenos.domain.response.smartShopping.DreamWithUserResponse
import retrofit2.Response
import retrofit2.http.*

interface SmartShoppingApi {

    @GET("v1.0/dreamType")
    suspend fun getDreamsType(): Response<ResponseWrapper<List<DreamTypeResponse>>>

    @POST("v1.0/dreamPlan")
    suspend fun createDreamPlan(@Body dream: DreamPlan?): Response<ResponseWrapper<String>>

    @PATCH("v1.0/dreamPlan")
    suspend fun updateDreamPlan(@Body dream: DreamPlan):  Response<ResponseWrapper<Boolean>>

    @GET("v1.0/dreamPlan")
    suspend fun getAllDreamsPlan(): Response<ResponseWrapperWithList<DreamWithUserResponse>>

    @GET("v1.0/dreamPlan/{dreamPlanId}")
    suspend fun getDreamById(@Path("dreamPlanId") dreamPlanId: String,@Query("priority") priority:String): Response<ResponseData<DreamWithUserResponse>>

    @GET("v1.0/dreamPlan/calendar/{dreamPlanId}")
    suspend fun getDreamPlanCalendar(@Path("dreamPlanId") dreamPlanId: String): Response<CalendarResponse>

    @POST("v1.0/dreamPlan/email/{dreamPlanId}")
    suspend fun sendDreamPlanEmail(@Path("dreamPlanId") dreamPlanId: String): Response<ResponseWrapper<Boolean>>

}