package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmulateDreamsViewModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(EmulateDreamsState())
        private set

    fun setStep(step: EmulateDreamsStep) {
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
}
