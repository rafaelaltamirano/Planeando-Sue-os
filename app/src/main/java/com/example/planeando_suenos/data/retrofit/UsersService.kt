package com.example.planeando_suenos.data.retrofit

import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.domain.response.ErrorResponse
import com.example.planeando_suenos.domain.response.users.CreateUserResponse
import com.example.planeando_suenos.domain.response.users.GetUserByIdResponse
import com.example.planeando_suenos.domain.response.users.UpdateUserResponse
import com.example.planeando_suenos.framework.retrofit.users.UsersApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersService @Inject constructor(private val usersApi: UsersApi) {

    suspend fun createUser(user: User): CreateUserResponse {
        return withContext(Dispatchers.IO) {
            val response = usersApi.createUser(user)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                CreateUserResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun updateUser(user: User): UpdateUserResponse {
        return withContext(Dispatchers.IO) {
            val response = usersApi.updateUser(user)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                UpdateUserResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun getUserById(id: String, token: String): GetUserByIdResponse {
        return withContext(Dispatchers.IO) {
            val response = usersApi.getUserById(id, token)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                GetUserByIdResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }
}