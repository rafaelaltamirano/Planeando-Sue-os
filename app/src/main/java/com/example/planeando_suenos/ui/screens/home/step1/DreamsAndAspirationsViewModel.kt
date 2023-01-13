package com.example.planeando_suenos.ui.screens.home.step1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.DreamAndAspirationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DreamsAndAspirationsViewModel @Inject constructor(
    private val dreamAndAspirationUseCase: DreamAndAspirationUseCase,
) : ViewModelWithStatus() {

    var state by mutableStateOf(DreamsAndAspirationsState())
        private set

    fun setStep(step: Step1Step) {
        state = state.copy(step = step)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
    }

    fun setChecked(check: Boolean) {
        state = state.copy(checked = check)
    }

    fun setDreamData(dreamData: DreamPlan) {
        state = state.copy(dreamData = dreamData)
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    private fun setDreamTypes(dreamTypes: List<DreamType>) {
        state = state.copy(dreamTypes = dreamTypes)
    }

     fun setDreamId(dreamId: String?) {
        state = state.copy(dreamId = dreamId)
    }

   suspend  fun submitDream() = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
               val  res = dreamAndAspirationUseCase.createDreamPlan(state.dreamData)
                setDreamId(res)
                setChecked(true)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    fun getDreamType() = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) { dreamAndAspirationUseCase.getDreamType() }.also {
                setDreamTypes(
                    it
                )
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

}