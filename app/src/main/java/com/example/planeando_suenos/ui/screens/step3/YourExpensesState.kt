package com.example.planeando_suenos.ui.screens.step3


enum class Step3Step(val step: Int) {

    EXPENSE_DATA(0),
    EXPENSE_RESUME(1),
    CONFIRMATION(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==2) EXPENSE_DATA else getByStep(step + 1)
    fun prev() = if (step==0) CONFIRMATION else getByStep(step - 1)
}

data class YourExpensesState(
    val loading: Boolean = false,
    val step: Step3Step = Step3Step.EXPENSE_DATA
)