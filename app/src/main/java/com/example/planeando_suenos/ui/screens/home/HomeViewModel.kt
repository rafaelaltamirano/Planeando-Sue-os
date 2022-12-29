package com.example.planeando_suenos.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.ui.screens.register.RegisterStep
import com.example.planeando_suenos.usescases.GetUserByIdUseCase
import com.example.planeando_suenos.usescases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
) : ViewModelWithStatus() {
    var state by mutableStateOf(HomeState())
        private set

    private fun setUser(user: User) {
        state = state.copy(user = user)
    }

    fun setCheckedStep1(check: Boolean) {
        state = state.copy(checkedStep1 = check)
    }

    fun setCheckedStep2(check: Boolean) {
        state = state.copy(checkedStep2 = check)
    }

    fun setCheckedStep3(check: Boolean) {
        state = state.copy(checkedStep3 = check)
    }

    fun setCheckedEmulateDreamStep(emulateDreamStep: Boolean) {
        state = state.copy(emulateDreamStep = emulateDreamStep)
    }

    fun getUserById(id: String, token: String) {
        viewModelScope.launch {
            val response = getUserByIdUseCase(id, token)
            if (response.success == true) {
                val user = response.data!!
                setUser(user)
            }
        }
    }
}