package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.domain.entities.Login
import javax.inject.Inject


class LoginUseCase @Inject constructor() {

    suspend fun login(): Login {
        return Login(1, "rafa", "rafa@gmail.com")

    }
}

