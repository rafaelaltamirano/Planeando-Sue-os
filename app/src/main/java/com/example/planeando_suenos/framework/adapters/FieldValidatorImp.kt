package com.example.planeando_suenos.framework.adapters

import com.apamatesoft.validator.Validator
import com.apamatesoft.validator.constants.Constants
import com.apamatesoft.validator.exceptions.InvalidEvaluationException
import com.apamatesoft.validator.messages.MessagesEs
import com.example.planeando_suenos.data.adapters.FieldValidator
import com.example.planeando_suenos.domain.enums.Fields
import com.example.planeando_suenos.domain.exceptions.FieldInvalidException
import javax.inject.Inject
import kotlin.jvm.Throws


class FieldValidatorImp @Inject constructor(): FieldValidator {


    init {
        Validator.setMessages(MessagesEs())
    }

    private val passwordValidatorOne by lazy {
        Validator().apply {
            required()
            minLength(8)
        }
    }

    private val passwordValidatorTwo by lazy {
        Validator().apply {
            mustContainOne(Constants.NUMBER)
        }
    }

    private val passwordValidatorThree by lazy {
        Validator().apply {
            mustContainOne(Constants.ALPHA_UPPERCASE)
            mustContainOne(Constants.ALPHA_LOWERCASE)
        }
    }

    override fun isPasswordValidOrFailOne(field: String): Boolean {
        val validator = passwordValidatorOne.copy()
        return try {
            validator.isValidOrFail(field)
            true
        } catch (e: InvalidEvaluationException) {
            false
        }
    }

    override fun isPasswordValidOrFailTwo(field: String): Boolean {
        val validator = passwordValidatorTwo.copy()
        return try {
            validator.isValidOrFail(field)
            true
        } catch (e: InvalidEvaluationException) {
            false
        }
    }
    override fun isPasswordValidOrFailThree(field: String): Boolean {
        val validator = passwordValidatorThree.copy()
        return try {
            validator.isValidOrFail(field)
            true
        } catch (e: InvalidEvaluationException) {
            false
        }
    }

    @Throws(FieldInvalidException::class)
    override fun isEmailValidOrFail(field: String): Boolean {
        val validator = Validator().apply {
            required("Por favor, ingresa tu usuario")
            email()
        }
        return try {
            validator.isValidOrFail(field)
              true
        } catch (e: InvalidEvaluationException) {
            throw FieldInvalidException(
                message = e.message!!,
                field = Fields.EMAIL
            )
        }
    }
}