package com.example.planeando_suenos.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.domain.entities.User
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase,
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

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    suspend fun getUserById(id: String, token: String) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) { homeUseCase.getUserByIdUseCase(id, token) }.also { setUser(it) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

}