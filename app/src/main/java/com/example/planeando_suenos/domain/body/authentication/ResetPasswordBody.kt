package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class ResetPasswordBody(
    @SerializedName("token") val token: String,
    @SerializedName("code") val code: String,
    @SerializedName("newPassword") val newPassword: String
)