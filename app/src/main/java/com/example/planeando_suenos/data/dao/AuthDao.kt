package com.example.planeando_suenos.data.dao

import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import java.io.File


interface AuthDao {

    suspend fun login(loginBody: LoginBody): Login

}