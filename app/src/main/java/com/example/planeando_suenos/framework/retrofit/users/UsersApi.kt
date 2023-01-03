package com.example.planeando_suenos.framework.retrofit.users

import com.example.planeando_suenos.domain.entities.User
import com.example.planeando_suenos.domain.response.ResponseWrapper
import com.example.planeando_suenos.domain.response.users.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface UsersApi {

    @POST("v1.0/users")
    suspend fun createUser(@Body user: User): Response<ResponseWrapper<String>>

    @PATCH("v1.0/users")
    suspend fun updateUser(@Body user: User): Response<ResponseWrapper<String>>

    @GET("v1.0/users/{id}")
    suspend fun getUserById(@Path("id") id: String): Response<ResponseWrapper<UserResponse>>
}