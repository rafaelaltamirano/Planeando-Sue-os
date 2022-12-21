package com.example.planeando_suenos.ui.screens.step1

enum class Step1Step(val step: Int) {

    DREAMS_GRID(0),
    DREAM_PLAN(1);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==1) DREAMS_GRID else getByStep(step + 1)
    fun prev() = if (step==0) DREAM_PLAN else getByStep(step - 1)
}


data class DreamsAndAspirationsState(
    val loading: Boolean = false,
    val step: Step1Step = Step1Step.DREAMS_GRID
)