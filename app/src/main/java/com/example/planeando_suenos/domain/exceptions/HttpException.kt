package com.example.domain.exceptions

data class HttpException(
    val code: Int,
    override val message: String? = null,
) : Exception(message)

