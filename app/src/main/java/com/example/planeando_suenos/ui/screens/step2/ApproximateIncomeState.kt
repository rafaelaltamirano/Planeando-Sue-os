package com.example.planeando_suenos.ui.screens.step2


enum class Step2Step(val step: Int) {

    INCOME_DATA(0),
    EXTRA_INCOMES(1),
    INCOME_FREQUENCY(2),
    CONFIRMATION(3);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step == 1) INCOME_DATA else getByStep(step + 1)
    fun prev() = if (step == 0) CONFIRMATION else getByStep(step - 1)
}

data class ApproximateIncomeState(
    val loading: Boolean = false,
    val step: Step2Step = Step2Step.INCOME_DATA
)