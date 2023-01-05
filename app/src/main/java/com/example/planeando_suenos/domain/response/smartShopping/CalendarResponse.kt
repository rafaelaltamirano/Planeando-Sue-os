package com.example.planeando_suenos.domain.response.smartShopping

import androidx.compose.ui.graphics.Color
import com.google.gson.annotations.SerializedName

data class CalendarResponse(
    @SerializedName("data") val data: DataCalendarResponse
)

data class DataCalendarResponse(
    @SerializedName("dreams") val dreams: List<DreamCalendarItem>
)

data class DreamCalendarItem(
    @SerializedName("year") val year: Int,
    @SerializedName("1-6") val eneJun: List<DreamItem>,
    @SerializedName("7-12") val julDic: List<DreamItem>,
)

data class DreamItem(
    @SerializedName("init") val monthInit: Int,
    @SerializedName("end") val monthFinish: Int,
    @SerializedName("color") val color: String
)