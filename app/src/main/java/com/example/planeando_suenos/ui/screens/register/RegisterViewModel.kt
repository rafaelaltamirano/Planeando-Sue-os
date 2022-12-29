package com.example.planeando_suenos.ui.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.LoginUseCase
import com.example.planeando_suenos.usescases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase
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

    fun setRepeatPassword(repeatPassword: String) {
        state = state.copy(repeatPassword = repeatPassword)
    }

    fun setName(name: String) {
        state = state.copy(name = name)
    }

    fun setSurname(surname: String) {
        state = state.copy(surname = surname)
    }

    fun setMotherName(motherSurname: String) {
        state = state.copy(motherSurname = motherSurname)
    }

    fun setBornDay(bornDay: String) {
        state = state.copy(bornDay = bornDay)
    }

    fun setPhone(phone: String) {
        state = state.copy(phone = phone)
    }

    fun setCp(cp: String) {
        state = state.copy(cp = cp)
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

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    private fun setId(id: String) {
        state = state.copy(id = id)
    }

    suspend fun registerUser() {
        viewModelScope.launch {
            val user = User(
                email = state.email,
                password = state.password,
                phoneNumber = state.phone,
                firstName = state.name,
                middleName = state.surname,
                lastName = state.motherSurname,
                birthday = state.bornDay,
                address = state.cp
            )
            val response = registerCase.registerUser(user)
            if (response.success == true) {
                val id = response.data!!
                setId(id)
            }
        }
    }

    private fun setToken(token: String) {
        state = state.copy(token = token)
    }

    suspend fun loginUser() {
        viewModelScope.launch {
            val loginBody = LoginBody(
                email = state.email,
                password = state.password
            )
            val response = loginUseCase.login(loginBody)
            if (response.success == true) {
                val token = response.data!!.token
                setToken(token)
            }
        }
    }


}