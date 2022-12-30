package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.DreamData
import com.example.planeando_suenos.domain.body.smartShopping.UserFinance
import com.google.gson.annotations.SerializedName

data class GetAllDreamsPlanResponse(
    @SerializedName("data") val data: List<DataGetAllDreamsPlanResponse>?,
    // Error response
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("details") val details: List<String>?,
)

data class DataGetAllDreamsPlanResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("user") val user: UserGetAllDreamPlan,
    @SerializedName("userFinance") val userFinance: UserFinance,
    @SerializedName("dream") val dream: List<DreamData>,
)

data class UserGetAllDreamPlan(
    @SerializedName("id") val id: String
)