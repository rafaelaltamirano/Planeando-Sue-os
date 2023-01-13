package com.example.planeando_suenos.ui.screens.restorePass

import com.example.planeando_suenos.domain.entities.Login

enum class RestorePasswordStep(val step: Int) {

    ENTER_EMAIL(0),
    PUT_PASSWORD(1),
    FINISH(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==2) ENTER_EMAIL else getByStep(step + 1)
    fun prev() = if (step==0) FINISH else getByStep(step - 1)
}

data class RestorePasswordState (
    val step: RestorePasswordStep = RestorePasswordStep.ENTER_EMAIL,
    val email: String = "",
    val newPassword: String = "",
    val repeatNewPassword: String = "",
    val loading: Boolean = false,
    val token: String? = null,
    val login: Login? = null,
    val validCharacter: Boolean? = null,
    val validNumber: Boolean? = null,
    val validMayus: Boolean? = null,
    val emailError: String = "",
    val passwordError: String? = null,
)