package com.example.planeando_suenos.framework.datasource

import com.example.planeando_suenos.data.dao.UserDao
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.User
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.framework.api.ApiTools
import com.example.planeando_suenos.framework.retrofit.users.UsersApi
import javax.inject.Inject


class UserDaoImp @Inject constructor(
    private val usersApi: UsersApi
) : UserDao {

    override suspend fun createUser(user: User): String {
        val res = usersApi.createUser(user)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data
    }

    override suspend fun updateUser(user: User): String {
        val res = usersApi.updateUser(user)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data
    }

    override suspend fun getUserById(id: String): User {
        val res = usersApi.getUserById(id)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.data.toEntity()
    }
}