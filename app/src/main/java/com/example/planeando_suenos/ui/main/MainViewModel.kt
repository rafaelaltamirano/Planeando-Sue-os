package com.example.planeando_suenos.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.domain.body.users.User
import com.example.planeando_suenos.domain.entities.Login
import com.example.planeando_suenos.ui.ModelStatus
import com.example.planeando_suenos.ui.ViewModelWithStatus
import com.example.planeando_suenos.usescases.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(MainState())
        private set


    fun setErrorStatus(errorStatus: ModelStatus?) {
        state = state.copy(errorStatus = errorStatus)
    }

    fun setNetworkErrorStatus(networkErrorStatus: ModelStatus?) {
        state = state.copy(networkErrorStatus = networkErrorStatus)
    }

    fun setInternetConnectionError(internetConnectionError: ModelStatus?) {
        state = state.copy(internetConnectionError = internetConnectionError)
    }

    fun setToken(token: String) {
        state = state.copy(token = token)
    }

    fun setId(id: String) {
        state = state.copy(id = id)
    }

    fun setUser(user: User) {
        state = state.copy(user = user)
    }

}
