package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(private val authDao: AuthDao) {

    suspend operator fun invoke(resetPasswordBody: ResetPasswordBody): Boolean {
        return authDao.resetPassword(resetPasswordBody)
    }
}