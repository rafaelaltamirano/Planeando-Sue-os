package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.GetDreamByIdAndPriorityUseCase
import com.example.planeando_suenos.usescases.GetDreamPlanCalendarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EmulateDreamsViewModel @Inject constructor(
    private val getDreamPlanCalendarUseCase: GetDreamPlanCalendarUseCase,
    private val getDreamByIdAndPriorityUseCase: GetDreamByIdAndPriorityUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(EmulateDreamsState())
        private set

    fun setStep(step: EmulateDreamsStep) {
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

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    private fun setDreamsCalendarItem(dreamsCalendarItem: List<DreamCalendarItem>) {
        state = state.copy(dreamsCalendarItem = dreamsCalendarItem)
    }

    private fun setDreamWithUser(dreamWithUser: DreamWithUser?) {
        state = state.copy(dreamWithUser = dreamWithUser)
    }

    fun getDreamCalendar(dreamId: String) {
        viewModelScope.launch {
            setLoading(true)
            try {
                withContext(Dispatchers.IO) {
                    getDreamPlanCalendarUseCase(dreamId)
                }.also { setDreamsCalendarItem(it) }
            } catch (e: Exception) {
                handleNetworkError(e)
            } finally {
                setLoading(false)
            }
        }
    }

    fun getDream(dreamId: String, priority: String) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) { getDreamByIdAndPriorityUseCase(dreamId, priority) }.also {
                setDreamWithUser(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    fun setPriority(priority: String) {
        state = state.copy(prioritySelected = priority)
    }


}
