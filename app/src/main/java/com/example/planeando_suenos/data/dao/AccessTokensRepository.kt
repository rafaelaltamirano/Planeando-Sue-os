package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login

class AccessTokensRepository(
    private val remote: AuthDao,
) {

    var accessTokens: Login? = null
        private set

    suspend fun requestAccessTokens(loginBody: LoginBody) = remote.login(loginBody)
        .also { save(it) }


      fun save(t: Login) {
        accessTokens = t
    }
}
