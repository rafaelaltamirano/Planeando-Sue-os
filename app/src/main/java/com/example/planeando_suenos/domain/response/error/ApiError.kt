package com.example.planeando_suenos.domain.response.error

import com.example.planeando_suenos.domain.response.Response


data class ApiError(
    val uuid: String,
    val code: String,
    val message: String,
    val details: List<String>,
) : Response<String> {



    override fun toEntity() = details.toString()

}
