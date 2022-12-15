package com.example.planeando_suenos.ui.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.ui.screens.home.HomeState
import com.example.planeando_suenos.usescases.HomeCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(RegisterState())
        private set


    fun setStep(step: RegisterStep) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

}