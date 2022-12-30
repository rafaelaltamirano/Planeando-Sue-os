package com.example.planeando_suenos.domain.response

interface Response<T> {

    fun toEntity(): T

}