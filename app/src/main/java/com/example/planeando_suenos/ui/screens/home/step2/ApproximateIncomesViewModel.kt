package com.example.planeando_suenos.ui.screens.home.step2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.*
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
    fun setFrequencyToShow(frequencyToShow: String) {
        state = state.copy(frequencyToShow = frequencyToShow)
    }
    fun setChecked(check: Boolean) {
        state = state.copy(checked = check)
    }

    fun setSalaryAmount(salaryAmount: Float?) {
        state = state.copy(salaryAmount = salaryAmount)
    }

    fun setAdditionalIncomes(additionalIncomes: Float?) {
        state = state.copy(additionalIncomes = additionalIncomes)
    }

    fun setSalaryType(salaryType: String) {
        state = state.copy(salaryType = salaryType)
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    fun setEdited(edited: Boolean) {
        state = state.copy(edited = edited)
    }


    fun setDreamId(dreamId: String) {
        state = state.copy(dreamId = dreamId)
    }

    fun getIncomeObject(): Income {
    return Income(
        type = state.salaryType,
        amount = state.salaryAmount,
        frequency = state.frequency,
        additionalIncomeAmount = state.additionalIncomes
    )
    }

    fun getDreamObject(): DreamPlan {
       return  DreamPlan(
           id = state.dreamId,
           userFinance = UserFinance(
               income = getIncomeObject(),
               expenses = Expenses(
                   home = 0f,
                   transport = 0f,
                   education = 0f,
                   hobby = 0f,
                   loanOrCredit = 0f,
                   totalExpense = 0f,
                   amountPerDay = 0f
               ),
           ),
       )
    }


    fun getDreamObjectWithAllData(
        expenses: Expenses,
        paymentCapability: Float,
        dreamList: List<Dream>?,
        initialPaymentCapability: Float,
        percentage: Float?
    ): DreamPlan {
        return  DreamPlan(
            id = state.dreamId,
            userFinance = UserFinance(
                income = getIncomeObject(),
                expenses = expenses,
                paymentCapability = paymentCapability,
                initialPaymentCapability = initialPaymentCapability,
                percentage = percentage
            ),
            dream = dreamList
        )
    }



    suspend fun updateDream(dreamPlan:DreamPlan) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
                approximateIncomeUseCase.updateDream(dreamPlan) }.also { setChecked(true) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)

        }
    }


}