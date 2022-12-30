package com.example.planeando_suenos.domain.response.smartShopping

import com.google.gson.annotations.SerializedName

data class GetDreamsTypeResponse(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<DataDreamType>?,
    // Error response
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("details") val details: List<String>?,
)

data class DataDreamType(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String
)
