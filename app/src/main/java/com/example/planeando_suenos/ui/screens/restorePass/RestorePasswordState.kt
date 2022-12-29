package com.example.planeando_suenos.ui.screens.restorePass

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
    val otpCode: String? = null,
    val newPassword: String = "",
    val repeatNewPassword: String = "",
    val loading: Boolean = false,
    val token: String? = null,
)