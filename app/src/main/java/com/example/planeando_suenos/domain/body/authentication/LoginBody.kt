package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class LoginBody(
    val email: String,
    val password: String
)
