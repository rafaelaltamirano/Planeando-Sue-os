package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.User


interface UserDao {
    suspend fun createUser(user: User): String
    suspend fun updateUser(user: User): String
    suspend fun getUserById(id: String): User


}