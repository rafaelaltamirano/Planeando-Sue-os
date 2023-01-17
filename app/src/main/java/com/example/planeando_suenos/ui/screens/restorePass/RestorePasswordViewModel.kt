package com.example.planeando_suenos.ui.screens.restorePass

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.authentication.ResetPasswordBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.enums.Fields
import com.example.planeando_suenos.domain.exceptions.FieldInvalidException
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.LoginUseCase
import com.example.planeando_suenos.usescases.RegisterUseCase
import com.example.planeando_suenos.usescases.ResetPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RestorePasswordViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerCase: RegisterUseCase,
    private val resetPasswordUseCase: ResetPasswordUseCase
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
        validatePassword(newPassword)
    }

    fun setRepeatNewPassword(repeatNewPassword: String) {
        state = state.copy(repeatNewPassword = repeatNewPassword)
    }

    private fun setLogin(login: Login) {
        state = state.copy(login = login)
    }

    fun setEmailError(emailError: String = "") {
        state = state.copy(emailError = emailError)
    }
    fun setPasswordError(passwordError: String = "") {
        state = state.copy(passwordError = passwordError)
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

    fun validateEmail(email: String): Boolean {
        return try {
            registerCase.isEmailValidOrFail(email)
        } catch (e: Exception) {
            handleNetworkError(e)
            false
        }
    }


    suspend fun login() {
        if (state.loading) return
        setLoading(true)
        try {
            viewModelScope.launch {
                val loginBody = LoginBody(
                    email = state.email,
                    password = state.newPassword
                )

                withContext(Dispatchers.IO) { loginUseCase.login(loginBody) }.also { setLogin(it) }

            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    fun setResetPassword(success: Boolean?) {
        state = state.copy(resetPasswordSuccess = success)
    }

    suspend fun resetPassword() {
        if (state.loading) return
        setLoading(true)
        try {
            viewModelScope.launch {
                val resetPasswordBody = ResetPasswordBody(
                    email = state.email,
                    newPassword = state.newPassword
                )

                withContext(Dispatchers.IO) { resetPasswordUseCase(resetPasswordBody) }.also { setResetPassword(it) }

            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    override fun onFieldInvalid(e: FieldInvalidException) {
        when (e.field) {
            Fields.EMAIL -> setEmailError(e.message)
            Fields.PASSWORD -> setPasswordError(e.message)
        }
        when (e.fieldSecond) {
            Fields.EMAIL -> setEmailError(e.message)
            Fields.PASSWORD -> setPasswordError(e.message)
            else -> {}
        }
    }

}