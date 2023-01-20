package com.example.planeando_suenos.ui.screens.register

import com.example.planeando_suenos.domain.entities.Login


enum class RegisterStep(val step: Int) {

    ACCOUNT(0),
    DATA(1),
    VERIFY(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step == 2) VERIFY else getByStep(step + 1)
    fun prev() = if (step == 0) ACCOUNT else getByStep(step - 1)
}

data class RegisterState(
    val step: RegisterStep = RegisterStep.ACCOUNT,
    val loading: Boolean = false,
    val email: String = "",
    val name: String = "",
    val surname: String = "",
    val motherSurname: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val bornDay: String = "",
    val phone: String = "",
    val cp: String = "",
    val validCharacter: Boolean? = null,
    val validNumber: Boolean? = null,
    val validMayus: Boolean? = null,
    val id: String? = null,
    val token: String? = null,
    val login: Login? = null,
    val emailError: String = "",
    val cpError: String = "",
    val passwordError: String? = null,
)