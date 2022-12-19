package com.example.planeando_suenos.data.adapters

interface FieldValidator {
    fun isPasswordValidOrFailOne(field: String):Boolean
    fun isPasswordValidOrFailTwo(field: String):Boolean
    fun isPasswordValidOrFailThree(field: String):Boolean
}