package com.example.planeando_suenos.ui.screens.step3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class YourExpensesIncomeViewModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(YourExpensesState())
        private set

    fun setStep(step: Step3Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }
}