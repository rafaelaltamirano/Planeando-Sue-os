package com.example.planeando_suenos.domain.response

data class ResponseWrapper<T>(
    val uuid: String,
    val success: Boolean,
    val data: T
)


