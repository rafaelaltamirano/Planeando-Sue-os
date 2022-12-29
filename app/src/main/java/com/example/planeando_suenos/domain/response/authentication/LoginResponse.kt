package com.example.planeando_suenos.domain.response.authentication

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("uuid") val uuid: String?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("data") val data: DataTokenResponse?,
    // Error response
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("details") val details: List<String>?
)

data class DataTokenResponse(
    @SerializedName("token") val token: String,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("id") val id: String,
)

