package com.example.planeando_suenos.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.planeando_suenos.domain.exceptions.FieldInvalidException
import com.example.planeando_suenos.domain.exceptions.UnauthorizedException
import retrofit2.HttpException
import java.net.UnknownHostException

open class ViewModelWithStatus : ViewModel() {

    var status by mutableStateOf<ModelStatus?>(null)
        protected set

    var errorStatus by mutableStateOf<ErrorStatus?>(ErrorStatus())
        protected set

    fun clearStatus() {
        status = null
    }

    fun updateStatus(status: ModelStatus) {
        this.status = status
    }

    fun setStatus(status: Status, message: String? = null) {
        this.status = ModelStatus(status, message)
        this.errorStatus = ErrorStatus()
    }

    fun setErrorDialog(show: Boolean) {
        errorStatus = errorStatus?.copy(showError = show)
        }

    fun setGenericErrorDialog(show: Boolean) {
        errorStatus =  errorStatus?.copy(showGenericError = show)
        }

    fun handleNetworkError(e: Exception) {
        println(">>: handleNetworkError: $e")
        status = when (e) {
            is HttpException ->  ModelStatus(Status.NETWORK_ERROR, e.message?.replace("Bad Request backend:", ""))
            is UnknownHostException -> ModelStatus(Status.INTERNET_CONNECTION_ERROR, e.message)
            is UnauthorizedException -> ModelStatus(Status.NETWORK_ERROR, e.message)
            else -> ModelStatus(Status.ERROR)

        }
    }

    protected open fun onFieldInvalid(e: FieldInvalidException) {}

}