package com.example.planeando_suenos.ui.screens.home.step3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class YourExpensesIncomeViewModel @Inject constructor(

) : ViewModelWithStatus() {

    var state by mutableStateOf(YourExpensesState())
        private set

    fun setStep(step: Step3Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    fun setChecked(checked: Boolean) {
        state = state.copy(checked = checked)
    }

    fun setCreditAmount(creditAmount: Float) {
        state = state.copy(creditAmount = creditAmount)
    }

    fun setCreditEndDate(creditEndDate: Float) {
        state = state.copy(creditEndDate = creditEndDate)
    }


    fun setHomeExpense(homeExpense: Float) {
        state = state.copy(homeExpense = homeExpense)
    }

    fun setTransportExpense(transportExpense: Float) {
        state = state.copy(transportExpense = transportExpense)
    }

    fun setEducationInversion(educationInversion: Float) {
        state = state.copy(educationInversion = educationInversion)
    }

    fun setEntertainmentExpense(entertainmentExpense: Float) {
        state = state.copy(entertainmentExpense = entertainmentExpense)
    }
}