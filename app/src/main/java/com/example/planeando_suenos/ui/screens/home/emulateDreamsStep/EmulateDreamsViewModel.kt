package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.DreamPlan
import com.example.planeando_suenos.domain.entities.Categories
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.GetDreamByIdAndPriorityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class EmulateDreamsViewModel @Inject constructor(
    private val getDreamByIdAndPriorityUseCase: GetDreamByIdAndPriorityUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(EmulateDreamsState())
        private set

    fun setStep(step: EmulateDreamsStep) {
        state = state.copy(step = step)
    }

    fun setCategories(categories: List<Categories>) {
        state = state.copy(categories = categories)
    }

    fun nextStep() {
        setStep(state.step.next())
    }

    fun prevStep() {
        setStep(state.step.prev())
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

    fun setCancelOnNext(cancelOnNext: Boolean) {
        state = state.copy(cancelOnNext = cancelOnNext)
    }

    fun setDreamId(dreamId: String) {
        state = state.copy(dreamId = dreamId)
    }

    fun setDreamName(dreamName: String) {
        state = state.copy(dreamName = dreamName)
    }

    fun setContentCreditSheet(contentCreditSheet: Boolean) {
        state = state.copy(contentCreditSheet = contentCreditSheet)
    }

    fun setDreamSendToEmail(status: Boolean) {
        state = state.copy(sendToEmail = status)
    }


    fun setPriority(priority: String?) {
        state = state.copy(prioritySelected = priority)
    }

    fun setPercentageSlider(percentage: Float) {
        state = state.copy(percentageSlider = percentage)
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


    fun getDreamCalendar(dreamId: String) {
        viewModelScope.launch {
            setLoading(true)
            try {
                withContext(Dispatchers.IO) {
                    getDreamByIdAndPriorityUseCase.getDreamPlanCalendar(dreamId)
                }.also { setDreamsCalendarItem(it) }
            } catch (e: Exception) {
                handleNetworkError(e)
            } finally {
                setLoading(false)
            }
        }
    }

    suspend fun updateDream(dreamPlan: DreamPlan) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
                val newUserFinanceWithPercentage = dreamPlan.userFinance?.copy(percentage = state.percentageSlider)
                getDreamByIdAndPriorityUseCase.updateDream(dreamPlan.copy(userFinance = newUserFinanceWithPercentage))
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)

        }
    }
     suspend fun sendDreamPlanEmail() = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
                getDreamByIdAndPriorityUseCase.sendDreamPlanEmail(state.dreamId)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)

        }
    }

    fun getDream(dreamId: String, priority: String) = viewModelScope.launch {
        setLoading(true)
        try {
            withContext(Dispatchers.IO) {
                getDreamByIdAndPriorityUseCase.getDreamById(
                    dreamId,
                    priority
                )
            }.also { setDreamWithUser(it) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }



    fun updateDreamAndGetCalendar() = viewModelScope.launch {
        updateDream(
            DreamPlan(
                title = state.dreamWithUser?.title,
                endDate = state.dreamWithUser?.endDate,
                userFinance = state.dreamWithUser?.userFinance,
                dream = state.dreamWithUser?.dream,
                id = state.dreamWithUser?.id
            )
        ).invokeOnCompletion {
            getDream(state.dreamId, state.prioritySelected ?: "").invokeOnCompletion {
                nextStep()
            }
        }
    }
}

