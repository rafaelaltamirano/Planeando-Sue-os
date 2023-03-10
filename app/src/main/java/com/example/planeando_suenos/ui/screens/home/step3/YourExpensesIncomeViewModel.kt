package com.example.planeando_suenos.ui.screens.home.step3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.*
import com.example.planeando_suenos.domain.entities.DreamWithUser
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

    fun setCreditAmount(creditAmount: String?) {
        state = state.copy(creditAmount = creditAmount)
    }

    fun setCreditEndDate(creditEndDate: String?) {
        state = state.copy(creditEndDate = creditEndDate)
    }

    fun setHasCredit(hasCredit: Boolean) {
        state = state.copy(hasCredit = hasCredit)
    }

    fun setCreditText(creditText: String) {
        state = state.copy(creditText = creditText)
    }

    fun setHomeExpense(homeExpense: String?) {
        state = state.copy(homeExpense = homeExpense)
    }

    fun setTransportExpense(transportExpense: String?) {
        state = state.copy(transportExpense = transportExpense)
    }

    fun setEducationInversion(educationInversion: String?) {
        state = state.copy(educationInversion = educationInversion)
    }

    fun setEntertainmentExpense(entertainmentExpense: String?) {
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

    fun resetStatus() {
        state = state.copy(transportExpense = null)
        state = state.copy(educationInversion = null)
        state = state.copy(entertainmentExpense = null)
        state = state.copy(creditAmount = null)
        state = state.copy(hasCredit = false)
        state = state.copy(creditEndDate = null )
    }

    fun getDreamObject(): DreamPlan {
        return  DreamPlan(
            id = state.dreamId,
            userFinance = UserFinance(
                expenses = Expenses(
                    home = state.homeExpense?.toFloat(),
                    transport = state.transportExpense?.toFloat(),
                    education = state.educationInversion?.toFloat(),
                    hobby = state.entertainmentExpense?.toFloat(),
                    loanOrCredit = if(state.hasCredit) state.creditAmount?.toFloat() ?: 0f else 0f,
                    loanOrCreditPaymentDate = state.creditEndDate
                ),
                income = state.income,
            ),
        )
    }

    fun getDreamObjectWithAllData(dreamWithUser: DreamWithUser?): DreamPlan {
        return  DreamPlan(
            id = state.dreamId,
            userFinance = UserFinance(
                expenses = Expenses(
                    home = state.homeExpense?.toFloat(),
                    transport = state.transportExpense?.toFloat(),
                    education = state.educationInversion?.toFloat(),
                    hobby = state.entertainmentExpense?.toFloat(),
                    loanOrCredit = if(state.hasCredit) state.creditAmount?.toFloat() ?: 0f else 0f,
                    loanOrCreditPaymentDate = state.creditEndDate
                ),
                income = state.income,
                percentage = dreamWithUser?.userFinance?.percentage
            ),
            dream = dreamWithUser?.dream
        )
    }


    suspend fun updateDream(dreamPlan: DreamPlan) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
                approximateIncomeUseCase.updateDream(dreamPlan)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }
}