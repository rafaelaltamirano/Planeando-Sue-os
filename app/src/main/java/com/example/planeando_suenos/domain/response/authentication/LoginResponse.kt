package com.example.planeando_suenos.domain.response.authentication

import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.response.Response


data class LoginResponse(
    val token: String,
    val refreshToken: String,
):Response<Login>{
    override fun toEntity() = Login (
        token = token,
        refreshToken = refreshToken
    )
}

