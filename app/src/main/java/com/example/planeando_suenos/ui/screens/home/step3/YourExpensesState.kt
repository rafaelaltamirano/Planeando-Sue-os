package com.example.planeando_suenos.ui.screens.home.step3

import com.example.planeando_suenos.domain.body.smartShopping.Income


enum class Step3Step(val step: Int) {

    FREQUENCY_EXPENSES(0),
    CREDIT_QUESTION(1),
    CREDIT_AMOUNT(2);


    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step == 2) CREDIT_AMOUNT else getByStep(step + 1)
    fun prev() = if (step == 0) FREQUENCY_EXPENSES else getByStep(step - 1)
}

data class YourExpensesState(
    val loading: Boolean = false,
    val hasCredit: Boolean = false,
    val creditText: String = "",
    val homeExpense: String? = null,
    val transportExpense: String? = null,
    val educationInversion: String? = null,
    val entertainmentExpense: String? = null,
    val creditAmount: String? = null,
    val creditEndDate: String? = null,
    val dreamId: String = "",
    val income: Income? = null,
    val step: Step3Step = Step3Step.FREQUENCY_EXPENSES
)