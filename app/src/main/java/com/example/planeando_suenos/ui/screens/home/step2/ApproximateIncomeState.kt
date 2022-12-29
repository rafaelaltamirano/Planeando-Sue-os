package com.example.planeando_suenos.ui.screens.home.step2


enum class Step2Step(val step: Int) {

    INCOME_DATA(0),
    FREQUENCY_INCOMES(1),
    EXTRA_INCOMES(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step == 3) EXTRA_INCOMES else getByStep(step + 1)
    fun prev() = if (step == 0) INCOME_DATA else getByStep(step - 1)
}

data class ApproximateIncomeState(
    val loading: Boolean = false,
    val step: Step2Step = Step2Step.INCOME_DATA,
    val frequency: String = "",
    val checked: Boolean = false,
    val salaryAmount: String = "",
    val additionalIncomes: String = ""
)