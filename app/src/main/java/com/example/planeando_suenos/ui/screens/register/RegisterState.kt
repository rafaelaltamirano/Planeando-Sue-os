package com.example.planeando_suenos.ui.screens.register

enum class RegisterStep(val step: Int) {

    ACCOUNT(0),
    DATA(1),
    VERIFY(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==2) VERIFY else getByStep(step + 1)

}

data class RegisterState (
    val step: RegisterStep = RegisterStep.ACCOUNT,
        )