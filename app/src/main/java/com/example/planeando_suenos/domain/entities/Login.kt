package com.example.planeando_suenos.domain.entities

data class Login(
    val token: String,
    val refreshToken: String,
)