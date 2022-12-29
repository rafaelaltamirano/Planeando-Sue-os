package com.example.planeando_suenos.domain.response.users

import com.example.planeando_suenos.domain.body.users.User
import com.google.gson.annotations.SerializedName

data class GetUserByIdResponse(
    @SerializedName("uuid") val uuid: String?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("data") val data: User?,
    // Error response
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("details") val details: List<String>?
)
