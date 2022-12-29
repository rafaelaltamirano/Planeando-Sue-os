package com.example.planeando_suenos.domain.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String = "Ocurrio un error inesperado",
    @SerializedName("details") val details: List<String> = emptyList(),
)
