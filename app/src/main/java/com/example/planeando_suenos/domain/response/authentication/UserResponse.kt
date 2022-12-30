package com.example.planeando_suenos.domain.response.authentication

import com.example.planeando_suenos.domain.entities.User
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("middleName") val middleName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("address") val address: String,
    @SerializedName("id") val id: String,
) : Response<User> {

    override fun toEntity() = User(
        email = email,
        password = password,
        phoneNumber = phoneNumber,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        birthday = birthday,
        address = address,
        id = id
    )
}


