package com.example.planeando_suenos.ui.screens.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val loading: Boolean = false,
    val token: String? = null,
    val id: String? = null
)