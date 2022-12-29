package com.example.planeando_suenos.ui.screens.login

import com.example.planeando_suenos.domain.entities.Login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val loading: Boolean = false,
    val login: Login? = null,
    val token: String? = null,
)