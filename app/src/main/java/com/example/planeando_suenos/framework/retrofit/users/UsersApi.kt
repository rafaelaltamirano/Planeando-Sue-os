package com.example.planeando_suenos.framework.retrofit.users

import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.domain.response.users.CreateUserResponse
import com.example.planeando_suenos.domain.response.users.GetUserByIdResponse
import com.example.planeando_suenos.domain.response.users.UpdateUserResponse
import retrofit2.Response
import retrofit2.http.*

interface UsersApi {

    @POST("v1.0/users")
    suspend fun createUser(@Body user: User): Response<CreateUserResponse>

    @PATCH("v1.0/users")
    suspend fun updateUser(@Body user: User): Response<UpdateUserResponse>

    @GET("v1.0/users/{id}")
    suspend fun getUserById(@Path("id") id: String, @Header("tokenjwt") token: String): Response<GetUserByIdResponse>
}