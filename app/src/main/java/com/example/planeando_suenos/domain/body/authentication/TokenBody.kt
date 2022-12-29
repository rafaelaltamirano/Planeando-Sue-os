package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class TokenBody(
    @SerializedName("token") val token: String
)
