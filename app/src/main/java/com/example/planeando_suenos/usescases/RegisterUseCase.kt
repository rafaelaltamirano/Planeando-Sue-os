package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.adapters.FieldValidator
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val fieldValidator: FieldValidator,) {

     fun validatePassOne(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailOne(text)
    }
    fun validatePassTwo(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailTwo(text)
    }
    fun validatePassThree(text: String): Boolean {
        return fieldValidator.isPasswordValidOrFailThree(text)
    }
}
