package com.example.planeando_suenos.framework.retrofit.authentication

import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import com.example.planeando_suenos.domain.response.ResponseSuccess
import com.example.planeando_suenos.domain.response.ResponseWrapper
import com.example.planeando_suenos.domain.response.authentication.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationApi {

    // Authentication User --------------------------

    @POST("v1.0/auth/login")
    suspend fun login(@Body loginBody: LoginBody): Response<ResponseWrapper<LoginResponse>>

    @POST("v1.0/auth/refresh-token")
    suspend fun refreshToken(@Body token: String):Response<ResponseWrapper<LoginResponse>>

    // Authentication Email ------------------------

    @POST("v1.0/auth-email/email-verification")
    suspend fun verifyEmail(@Query("token") token: String): Response<ResponseSuccess>

    @POST("v1.0/auth-email/resend-token")
    suspend fun resendEmailVerificationToken(): Response<ResponseSuccess>

    // Authentication Password ---------------------

    @POST("v1.0/auth-password/recovery")
    suspend fun sendOTPCodeForPasswordRecovery(@Body emailBody: String): Response<ResponseSuccess>

    @POST("v1.0/auth-password/reset-password")
    suspend fun resetPassword(@Body resetPasswordBody: ResetPasswordBody): Response<ResponseSuccess>

}