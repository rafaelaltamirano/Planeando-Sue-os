package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.response.smartShopping.DreamCalendarItem

enum class EmulateDreamsStep(val step: Int) {

    REVIEW_NUMBERS(0),
    LIST(1),
    CALENDAR(2);

    companion object {
        fun getByStep(step: Int) = values().first { it.step == step }
    }

    fun next() = if (step==3) CALENDAR else getByStep(step + 1)
    fun prev() = if (step==0) REVIEW_NUMBERS else getByStep(step - 1)
}


data class EmulateDreamsState(
    val loading: Boolean = true,
    val step: EmulateDreamsStep = EmulateDreamsStep.REVIEW_NUMBERS,
    val checked: Boolean = false,
    val dreamsCalendarItem: List<DreamCalendarItem> = emptyList(),
    val dreamWithUser: DreamWithUser? = null,
    val prioritySelected: String? = null,
    val newAmount: Float? = null,
    val dreamListUpdated: List<Dream> = emptyList()

)