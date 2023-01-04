package com.example.planeando_suenos.ui.screens.home.step2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.authentication.LoginBody
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.ApproximateIncomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ApproximateIncomesViewModel @Inject constructor(
    private val approximateIncomeUseCase: ApproximateIncomeUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(ApproximateIncomeState())
        private set

    init {
        getDream(state.dreamId)

    }

    fun setStep(step: Step2Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    fun setFrequency(frequency: String) {
        state = state.copy(frequency = frequency)
    }

    fun setChecked(check: Boolean) {
        state = state.copy(checked = check)
    }

    fun setSalaryAmount(salaryAmount: String) {
        state = state.copy(salaryAmount = salaryAmount)
    }

    fun setAdditionalIncomes(additionalIncomes: String) {
        state = state.copy(additionalIncomes = additionalIncomes)
    }

    fun setVariableSalary(variableSalary: Boolean) {
        state = state.copy(variableSalary = variableSalary)
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    private fun setDreamWithUser(dreamWithUser: DreamWithUser?) {
        state = state.copy(dreamWithUser = dreamWithUser)
    }

    fun setDreamId(dreamId: String) {
        state = state.copy(dreamId = dreamId)
    }


    fun getDream(dreamId: String) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) { approximateIncomeUseCase.getDream(dreamId) }.also {
                setDreamWithUser(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

}