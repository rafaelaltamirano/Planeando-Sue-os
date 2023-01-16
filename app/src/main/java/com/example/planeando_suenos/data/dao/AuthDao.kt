package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import com.example.planeando_suenos.domain.entities.Login


interface AuthDao {

    suspend fun login(loginBody: LoginBody): Login
    suspend fun refreshToken(token:String): Login
    suspend fun verifyEmail(token: String)
    suspend fun resendEmailVerificationToken()
    suspend fun sendOTPCodeForPasswordRecovery(email: String)
    suspend fun resetPassword(resetPasswordBody: ResetPasswordBody): Boolean

}