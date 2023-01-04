package com.example.planeando_suenos.ui.screens.home

import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.entities.User


data class HomeState(
    val checkedStep1: Boolean = false,
    val checkedStep2: Boolean = false,
    val checkedStep3: Boolean = false,
    val emulateDreamStep: Boolean = false,
    val loading: Boolean = false,
    val user: User? = null,
)
