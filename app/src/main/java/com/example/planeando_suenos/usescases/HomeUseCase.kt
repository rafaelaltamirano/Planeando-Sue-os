package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.data.dao.UserDao
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.entities.User
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val userDao: UserDao,
                                      private val smartShoppingDao:SmartShoppingDao) {

    suspend fun getUserByIdUseCase(id: String): User {
        return userDao.getUserById(id)
    }

    suspend fun getAllDreams(): List<DreamWithUser> {
        return smartShoppingDao.getAllDreamsPlan()
    }
}

