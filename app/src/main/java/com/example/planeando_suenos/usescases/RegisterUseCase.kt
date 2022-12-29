package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.adapters.FieldValidator
import com.example.planeando_suenos.data.retrofit.UsersService
import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.domain.response.users.CreateUserResponse
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val fieldValidator: FieldValidator,
    private val usersService: UsersService
) {

    fun validatePassOne(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailOne(text)
    }

    fun validatePassTwo(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailTwo(text)
    }

    fun validatePassThree(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailThree(text)
    }

    suspend fun registerUser(user: User): CreateUserResponse {
        return usersService.createUser(user)
    }
}
