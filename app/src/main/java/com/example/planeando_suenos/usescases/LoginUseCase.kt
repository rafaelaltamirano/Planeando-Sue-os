package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.AccessTokensRepository
import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.response.authentication.LoginResponse
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val accessTokensRepository: AccessTokensRepository) {

    suspend fun login(loginBody: LoginBody): Login {
        return accessTokensRepository.requestAccessTokens(loginBody)
    }
}

