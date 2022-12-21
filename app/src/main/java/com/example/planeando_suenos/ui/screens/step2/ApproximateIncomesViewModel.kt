package com.example.planeando_suenos.ui.screens.step2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.ui.screens.step1.DreamsAndAspirationsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ApproximateIncomesViewModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(ApproximateIncomeState())
        private set

    fun setStep(step: Step2Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }
}