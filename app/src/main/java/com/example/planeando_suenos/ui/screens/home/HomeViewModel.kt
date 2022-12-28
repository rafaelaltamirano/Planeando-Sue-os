package com.example.planeando_suenos.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.ui.screens.register.RegisterStep
import com.example.planeando_suenos.usescases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModelWithStatus() {
    var state by mutableStateOf(HomeState())
        private set

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
}