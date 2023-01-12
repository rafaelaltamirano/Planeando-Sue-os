package com.example.planeando_suenos.framework.datasource

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.framework.api.ApiTools
import com.example.planeando_suenos.framework.retrofit.authentication.AuthenticationApi
import javax.inject.Inject


class AuthDaoImp @Inject constructor(
    private val authenticationApi: AuthenticationApi
) : AuthDao {

    override suspend fun login(loginBody: LoginBody): Login {

        //LOGIN MOCK
        val send = LoginBody("user@user.com","1234567890pP")
        val res = authenticationApi.login(send)
//
//        val res = authenticationApi.login(loginBody)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.toEntity()
    }

    override suspend fun refreshToken(token: String): Login {
        val res = authenticationApi.refreshToken(token)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.toEntity()
    }

    override suspend fun verifyEmail(token: String) {
        val res = authenticationApi.verifyEmail(token)
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun resendEmailVerificationToken() {
        val res = authenticationApi.resendEmailVerificationToken()
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun sendOTPCodeForPasswordRecovery(email: String) {
        val res = authenticationApi.sendOTPCodeForPasswordRecovery(email)
        ApiTools.validateResponseOrFail(res)
    }

    override suspend fun resetPassword(resetPasswordBody: ResetPasswordBody) {
        val res = authenticationApi.resetPassword(resetPasswordBody)
        ApiTools.validateResponseOrFail(res)
    }
}
