package com.example.planeando_suenos.domain.response.error

import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName


data class ApiError(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("code")  val code: String,
    @SerializedName("message")  val message: String,
    @SerializedName("details") val details: List<String>,
) : Response<String> {
    override fun toEntity() = details.toString()
}
