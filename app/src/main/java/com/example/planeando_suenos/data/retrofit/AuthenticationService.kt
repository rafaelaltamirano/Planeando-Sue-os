package com.example.planeando_suenos.data.retrofit

import com.example.planeando_suenos.domain.body.authentication.EmailBody
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import com.example.planeando_suenos.domain.body.authentication.TokenBody
import com.example.planeando_suenos.domain.response.ErrorResponse
import com.example.planeando_suenos.domain.response.authentication.LoginResponse
import com.example.planeando_suenos.domain.response.authentication.SuccessResponse
import com.example.planeando_suenos.framework.retrofit.authentication.AuthenticationApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthenticationService @Inject constructor(private val authenticationApi: AuthenticationApi) {

//    suspend fun login(loginBody: LoginBody): LoginResponse {
//        return withContext(Dispatchers.IO) {
//            val response = authenticationApi.login(loginBody)
//            response.body() ?: run {
//                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
//                LoginResponse(
//                    uuid = errorResponse.uuid,
//                    success = false,
//                    data = null,
//                    code = errorResponse.code,
//                    message = errorResponse.message,
//                    details = errorResponse.details
//                )
//            }
//        }
//    }

//    suspend fun refreshToken(tokenBody: TokenBody): LoginResponse {
//        return withContext(Dispatchers.IO) {
//            val response = authenticationApi.refreshToken(tokenBody)
//            response.body() ?: run {
//                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
//                LoginResponse(
//                    uuid = errorResponse.uuid,
//                    success = false,
//                    data = null,
//                    code = errorResponse.code,
//                    message = errorResponse.message,
//                    details = errorResponse.details
//                )
//            }
//        }
//    }

    suspend fun verifyEmail(token: String): SuccessResponse {
        return withContext(Dispatchers.IO) {
            val response = authenticationApi.verifyEmail(token)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun resendEmailVerificationToken(): SuccessResponse {
        return withContext(Dispatchers.IO) {
            val response = authenticationApi.resendEmailVerificationToken()
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun sendOTPCodeForPasswordRecovery(emailBody: EmailBody): SuccessResponse {
        return withContext(Dispatchers.IO) {
            val response = authenticationApi.sendOTPCodeForPasswordRecovery(emailBody)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun resetPassword(resetPasswordBody: ResetPasswordBody): SuccessResponse {
        return withContext(Dispatchers.IO) {
            val response = authenticationApi.resetPassword(resetPasswordBody)
            response.body() ?: run {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }
}