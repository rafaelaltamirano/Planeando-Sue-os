package com.example.planeando_suenos.domain.response

data class ResponseWrapperWithList<T>(
    val uuid: String,
    val success: Boolean,
    val data: List<T>
)