package com.example.planeando_suenos.domain.exceptions

data class HttpException(
    val code: Int,
    override val message: String? = null,
) : Exception(message)

