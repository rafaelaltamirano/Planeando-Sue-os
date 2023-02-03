package com.example.planeando_suenos.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.entities.User
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

    fun setDreamEdit(dreamEdit: DreamWithUser?) {
        state = state.copy(dreamEdit = dreamEdit)
    }

    fun setDreamId(dreamId: String?) {
        state = state.copy(dreamId = dreamId)
    }

    fun setDreamWithUserList(dreamWithUser: List<DreamWithUser>?) {
        state = state.copy(dreamWithUser = dreamWithUser)
    }

    fun setErrorStatus(errorStatus: ModelStatus?) {
        state = state.copy(errorStatus = errorStatus)
    }

    fun setNetworkErrorStatus(networkErrorStatus: ModelStatus?) {
        state = state.copy(networkErrorStatus = networkErrorStatus)
    }

    fun setInternetConnectionError(internetConnectionError: ModelStatus?) {
        state = state.copy(internetConnectionError = internetConnectionError)
    }

    fun setLogin(login: Login) {
        state = state.copy(login = login)
    }

    fun setId(id: String) {
        state = state.copy(id = id)
    }
    fun setUser(user: User) {
        state = state.copy(user = user)
    }

}
