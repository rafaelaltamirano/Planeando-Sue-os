package com.example.planeando_suenos.ui.screens.home.step2

import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.entities.DreamWithUser


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
    val frequencyToShow: String = "",
    val checked: Boolean = false,
    val salaryAmount: Float? = null,
    val additionalIncomes: Float? = null,
    val salaryType: String = "",
    val dreamWithUser: DreamWithUser? = null,
    val dreamId: String = "",
    val dream: DreamPlan? = null,
)