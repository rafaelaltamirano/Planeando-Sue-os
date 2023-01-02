package com.example.planeando_suenos.ui.screens.home.step1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.domain.body.smartShopping.DreamBody
import com.example.planeando_suenos.domain.entities.Dream
import com.example.planeando_suenos.ui.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DreamsAndAspirationsViewModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(DreamsAndAspirationsState())
        private set

    fun setStep(step: Step1Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    fun setChecked(check: Boolean) {
        state = state.copy(checked = check)
    }

    fun setDreamData(dreamData: DreamBody) {
        state = state.copy(dreamData = dreamData)
    }

}