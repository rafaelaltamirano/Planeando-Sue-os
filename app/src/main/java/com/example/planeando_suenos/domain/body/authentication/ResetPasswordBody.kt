package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class ResetPasswordBody(
    @SerializedName("email") val email: String,
    @SerializedName("newPassword") val newPassword: String
)
