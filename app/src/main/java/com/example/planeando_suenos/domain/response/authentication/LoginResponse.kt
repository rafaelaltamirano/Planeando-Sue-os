package com.example.planeando_suenos.domain.response.authentication

import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("token") val token: String,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("userId") val userId: String,
) : Response<Login> {
    override fun toEntity() = Login(
        token = token,
        refreshToken = refreshToken,
        id = userId
    )
}


