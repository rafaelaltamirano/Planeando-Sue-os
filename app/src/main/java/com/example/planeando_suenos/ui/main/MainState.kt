package com.example.planeando_suenos.ui.main

import com.example.planeando_suenos.domain.entities.Login

data class MainState(
    val scope: String?= null,
    val login: Login? = null,
    val showSplash: Boolean = true,
    )