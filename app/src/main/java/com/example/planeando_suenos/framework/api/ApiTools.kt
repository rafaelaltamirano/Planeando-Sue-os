package com.example.planeando_suenos.framework.api

import com.example.planeando_suenos.domain.exceptions.HttpException
import com.example.planeando_suenos.domain.exceptions.UnauthorizedException
import com.example.planeando_suenos.domain.response.error.ApiError
import com.google.gson.Gson
import retrofit2.Response
import java.lang.Exception

object ApiTools {

    fun <T> validateResponseOrFail(res: Response<T>) {
        if (res.isSuccessful) return
        val error = res.errorBody()!!.string()
        when (val code = res.code()) {
            401 -> throw UnauthorizedException()
            else -> {
                val errorMessage = try {
                    Gson().fromJson(error, ApiError::class.java).toEntity()
                } catch (e: Exception) {
                    res.message()
                }
                throw HttpException(code, errorMessage)
            }
        }
    }
}