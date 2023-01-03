package com.example.planeando_suenos.domain.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
   val uuid: String,
    val code: String,
  val message: String = "Ocurrio un error inesperado",
    @SerializedName("details") val details: List<String> = emptyList(),
)
