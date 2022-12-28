package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

enum class EmulateDreamsStep(val step: Int) {

    REVIEW_NUMBERS(0),
    CALENDAR(1),
    CONFIRMATION(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==2) CONFIRMATION else getByStep(step + 1)
    fun prev() = if (step==0) REVIEW_NUMBERS else getByStep(step - 1)
}


data class EmulateDreamsState(
    val loading: Boolean = false,
    val step: EmulateDreamsStep = EmulateDreamsStep.REVIEW_NUMBERS,
    val checked: Boolean = false
)