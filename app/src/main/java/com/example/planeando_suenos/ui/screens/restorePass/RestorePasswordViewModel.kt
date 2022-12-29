package com.example.planeando_suenos.ui.screens.restorePass

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RestorePasswordViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(RestorePasswordState())
        private set

    fun setStep(step: RestorePasswordStep) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    fun setEmail(email: String) {
        state = state.copy(email = email)
    }

    fun setNewPassword(newPassword: String) {
        state = state.copy(newPassword = newPassword)
    }

    fun setRepeatNewPassword(repeatNewPassword: String) {
        state = state.copy(repeatNewPassword = repeatNewPassword)
    }

    private fun setToken(token: String) {
        state = state.copy(token = token)
    }

    fun login() {
        viewModelScope.launch {
            val loginBody = LoginBody(
                email = state.email,
                password = state.newPassword
            )
            val response = loginUseCase.login(loginBody)
            if (response.success == true) {
                val token = response.data!!.token
                setToken(token)
            }
        }
    }

}