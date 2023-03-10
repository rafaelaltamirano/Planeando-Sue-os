package com.example.planeando_suenos.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.enums.Fields
import com.example.planeando_suenos.domain.exceptions.FieldInvalidException
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(LoginState())
        private set

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    fun setEmailError(emailError: String = "") {
        state = state.copy(emailError = emailError)
    }

    fun setPasswordError(passwordError: String = "") {
        state = state.copy(passwordError = passwordError)
    }

    fun setEmail(email: String) {
        state = state.copy(email = email)
    }

    fun setPassword(password: String) {
        state = state.copy(password = password)
    }

    private fun setLogin(login: Login) {
        state = state.copy(login = login)
    }

    fun validateEmail(email: String): Boolean {
        return try {
            loginUseCase.isEmailValidOrFail(email.lowercase())
        } catch (e: Exception) {
            handleNetworkError(e)
            false
        }
    }

    suspend fun login() = viewModelScope.launch {
        setLoading(true)
        try {
            val loginBody = LoginBody(
                email = state.email,
                password = state.password
            )
            withContext(IO) { loginUseCase.login(loginBody) }.also { setLogin(it) }
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