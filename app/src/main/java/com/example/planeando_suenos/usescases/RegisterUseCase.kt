package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.adapters.FieldValidator
import com.example.planeando_suenos.data.dao.UserDao
import com.example.planeando_suenos.domain.entities.User
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val fieldValidator: FieldValidator,
    private val userDao: UserDao
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

    fun isEmailValidOrFail(text: String) {
        return fieldValidator.isEmailValidOrFail(text)
    }

    suspend fun registerUser(user: User): String {

        return userDao.createUser(user)
    }
}
