package com.example.planeando_suenos.domain.entities


data class User(
    val email: String,
    val password: String,
    val phoneNumber: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val birthday: String,
    val address: String,
    val id: String? = null,
)
