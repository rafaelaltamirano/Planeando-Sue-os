package com.example.planeando_suenos.framework.datasource

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.framework.api.ApiTools
import com.example.planeando_suenos.framework.retrofit.authentication.AuthenticationApi
import javax.inject.Inject


class AuthDaoImp @Inject constructor(
    private val authenticationApi: AuthenticationApi
) : AuthDao {

    override suspend fun login(loginBody: LoginBody): Login {

        val res = authenticationApi.login(loginBody)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.toEntity()

    }
}
