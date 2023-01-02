package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.retrofit.UsersService
import com.example.planeando_suenos.domain.response.users.GetUserByIdResponse
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val usersService: UsersService) {

    suspend operator fun invoke(id: String, token: String): GetUserByIdResponse {
        return usersService.getUserById(id, token)
    }
}