package com.example.planeando_suenos.ui.screens.home.step3


enum class Step3Step(val step: Int) {

    FREQUENCY_EXPENSES(0),
    CREDIT_QUESTION(1),
    CREDIT_AMOUNT(2),
    CONFIRMATION(3);


    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==3) CONFIRMATION else getByStep(step + 1)
    fun prev() = if (step==0) FREQUENCY_EXPENSES else getByStep(step - 1)
}

data class YourExpensesState(
    val loading: Boolean = false,
    val checked: Boolean = false,
    val homeExpense: String = "",
    val transportExpense: String = "",
    val educationInversion: String = "",
    val entertainmentExpense : String = "",
    val creditAmount: String = "",
    val creditEndDate: String = "",
    val step: Step3Step = Step3Step.FREQUENCY_EXPENSES
)