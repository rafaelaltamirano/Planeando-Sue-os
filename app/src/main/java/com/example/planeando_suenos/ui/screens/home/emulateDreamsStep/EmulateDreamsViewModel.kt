package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.GetDreamByIdAndPriorityUseCase
import com.example.planeando_suenos.usescases.GetDreamPlanCalendarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.FieldPosition
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

    fun setDreamWithUser(dreamWithUser: DreamWithUser?) {
        state = state.copy(dreamWithUser = dreamWithUser)
    }

    fun setNewDreamListUpdate(newDream: Dream, position: Int) {
        val list = state.dreamWithUser?.dream?.toMutableList()
        list?.set(position, newDream)
        val dreamWithUserUpdated = DreamWithUser(
            id = state.dreamWithUser?.id,
            title = state.dreamWithUser?.title,
            active = state.dreamWithUser?.active,
            user = state.dreamWithUser?.user,
            endDate = state.dreamWithUser?.endDate,
            userFinance = state.dreamWithUser?.userFinance,
            dream = list
        )

        state = state.copy(dreamWithUser = dreamWithUserUpdated)
    }

    fun setCancelOnNext(cancelOnNext: Boolean) {
        state = state.copy(cancelOnNext = cancelOnNext)
    }

    fun setNewAmount(newAmount: Float?) {
        state = state.copy(newAmount = newAmount)
    }

    fun setDreamListUpdated(dreamListUpdated: List<Dream>) {
        state = state.copy(dreamListUpdated = dreamListUpdated)
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
