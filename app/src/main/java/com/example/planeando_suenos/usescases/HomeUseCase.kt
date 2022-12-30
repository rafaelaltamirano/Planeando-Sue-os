package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.UserDao
import com.example.planeando_suenos.domain.entities.User
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val userDao: UserDao) {

    suspend fun getUserByIdUseCase(id: String, token: String): User {
        return userDao.getUserById(id, token)
    }
}

