package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.adapters.FieldValidator
import com.example.planeando_suenos.data.dao.AccessTokensRepository
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val accessTokensRepository: AccessTokensRepository,
    private val fieldValidator: FieldValidator,
) {

    suspend fun login(loginBody: LoginBody): Login {
        return accessTokensRepository.requestAccessTokens(loginBody)
    }

    fun isEmailValidOrFail(text: String): Boolean {
        return fieldValidator.isEmailValidOrFail(text)
    }
}

