package com.example.planeando_suenos.ui.main

import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.ui.ModelStatus

data class MainState(
    val scope: String?= null,
    val login: Login? = null,
    val showSplash: Boolean = true,
    val errorStatus: ModelStatus? = null,
    val networkErrorStatus: ModelStatus? = null,
    val internetConnectionError: ModelStatus? = null,
    )