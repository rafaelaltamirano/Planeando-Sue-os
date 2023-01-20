package com.example.planeando_suenos.ui.screens.home.step1

import androidx.compose.runtime.remember
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType

enum class Step1Step(val step: Int) {

    DREAMS_GRID(0),
    DREAM_PLAN(1);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step == 1) DREAM_PLAN else getByStep(step + 1)
    fun prev() = if (step == 0) DREAMS_GRID else getByStep(step - 1)
}


data class DreamsAndAspirationsState(
    val loading: Boolean = false,
    val step: Step1Step = Step1Step.DREAMS_GRID,
    val checked: Boolean = false,
    val dreamId: String? = null,
    val dreamData: DreamPlan? = null,
    val dreamTypes: List<DreamType> = emptyList(),
    val dreamAmount: List<String> = emptyList(),
)