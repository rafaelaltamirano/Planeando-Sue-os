package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class LoginBody(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
