package com.example.planeando_suenos.framework.api.schemas.response

interface Response<T> {

    fun toEntity(): T

}