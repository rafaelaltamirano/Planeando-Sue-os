package com.example.planeando_suenos.data.adapters

import com.example.planeando_suenos.domain.exceptions.FieldInvalidException
import kotlin.jvm.Throws

interface FieldValidator {
    fun isPasswordValidOrFailOne(field: String):Boolean
    fun isPasswordValidOrFailTwo(field: String):Boolean
    fun isPasswordValidOrFailThree(field: String):Boolean
    @Throws(FieldInvalidException::class)
    fun isEmailValidOrFail(field: String)
}