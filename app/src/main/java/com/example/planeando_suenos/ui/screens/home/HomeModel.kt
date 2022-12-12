package com.example.planeando_suenos.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.HomeCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    private val homeCase: HomeCase
) : ViewModelWithStatus() {
    var state by mutableStateOf(HomeState())
        private set

    init {
    }

}