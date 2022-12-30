package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.data.retrofit.AuthenticationService
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.response.authentication.LoginResponse
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val authDao: AuthDao) {

    suspend fun login(loginBody: LoginBody): Login {
        return authDao.login(loginBody)
    }
}

