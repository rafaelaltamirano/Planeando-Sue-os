package com.example.planeando_suenos.ui.screens.step1

import com.example.planeando_suenos.ui.screens.step2.Step2Step

enum class Step1Step(val step: Int) {

    DREAM_TYPE(0),
    DREAM_DATA(1);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==2) DREAM_TYPE else getByStep(step + 1)
    fun prev() = if (step==0) DREAM_DATA else getByStep(step - 1)
}


data class DreamsAndAspirationsState(
    val loading: Boolean = false,
    val step: Step1Step = Step1Step.DREAM_TYPE
)