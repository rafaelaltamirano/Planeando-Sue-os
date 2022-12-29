package com.example.planeando_suenos.domain.body.authentication

import com.google.gson.annotations.SerializedName

data class EmailBody(
    @SerializedName("email") val email: String
)
