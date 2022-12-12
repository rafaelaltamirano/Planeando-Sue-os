package com.example.planeando_suenos.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.MainCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(
    private val mainCase: MainCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(MainState())
        private set

    fun setLogin(login: Login) {
        state = state.copy(login = login)
    }

}
