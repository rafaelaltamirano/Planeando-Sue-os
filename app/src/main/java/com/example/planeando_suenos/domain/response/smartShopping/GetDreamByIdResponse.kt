package com.example.planeando_suenos.domain.response.smartShopping

import com.google.gson.annotations.SerializedName

data class GetDreamByIdResponse(
    @SerializedName("data") val data: DataGetAllDreamsPlanResponse?,
    // Error response
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("details") val details: List<String>?,
)
