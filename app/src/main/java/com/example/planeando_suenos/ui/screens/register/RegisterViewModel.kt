package com.example.planeando_suenos.ui.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerCase : RegisterUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(RegisterState())
        private set


    fun setEmail(email: String) {
        state = state.copy(email = email)
    }

    fun setPassword(password: String) {
        state = state.copy(password = password)
        validatePassword(password)
    }

    fun setStep(step: RegisterStep) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    fun passOne(condition: Boolean) {
        state = state.copy(validCharacter = condition)
    }

    fun passTwo(condition: Boolean) {
        state = state.copy(validMayus = condition)
    }

    fun passThree(condition: Boolean) {
        state = state.copy(validNumber = condition)
    }

    fun validatePassword(password: String) {
        passOne(registerCase.validatePassOne(password))
        passTwo(registerCase.validatePassTwo(password))
        passThree(registerCase.validatePassThree(password))
    }


}