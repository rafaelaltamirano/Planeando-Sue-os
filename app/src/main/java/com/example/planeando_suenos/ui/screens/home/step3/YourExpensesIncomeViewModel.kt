package com.example.planeando_suenos.ui.screens.home.step3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.Expenses
import com.example.planeando_suenos.domain.body.smartShopping.Income
import com.example.planeando_suenos.domain.body.smartShopping.UserFinance
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.ApproximateIncomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class YourExpensesIncomeViewModel @Inject constructor(
    private val approximateIncomeUseCase: ApproximateIncomeUseCase
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

    fun setCreditEndDate(creditEndDate: String) {
        state = state.copy(creditEndDate = creditEndDate)
    }

    fun setHasCredit(hasCredit: Boolean) {
        state = state.copy(hasCredit = hasCredit)
    }

    fun setCreditText(creditText: String) {
        state = state.copy(creditText = creditText)
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

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    fun setDreamId(dreamId: String) {
        state = state.copy(dreamId = dreamId)
    }

    fun setIncome(income: Income?) {
        state = state.copy(income = income)
    }

    fun getDreamObject(): DreamPlan {
        return  DreamPlan(
            id = state.dreamId,
            userFinance = UserFinance(
                expenses = Expenses(
                    home = state.homeExpense,
                    transport = state.transportExpense,
                    education = state.educationInversion,
                    hobby = state.entertainmentExpense,
                    loanOrCredit = state.creditAmount,
                    loanOrCreditPaymentDate = state.creditEndDate
                ),
                income = state.income
            ),

        )
    }


    suspend fun updateDream(dreamPlan: DreamPlan) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) { approximateIncomeUseCase.updateDream(dreamPlan) }.also { setChecked(true) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }
}