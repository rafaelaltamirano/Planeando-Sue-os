package com.example.planeando_suenos.domain.body.smartShopping

import com.example.planeando_suenos.ui.screens.home.step1.dreamsGrid.DreamType
import com.google.gson.annotations.SerializedName

data class DreamBody(
    val title: String? = null,
    val userFinance: UserFinanceBody? = null,
    val dream: List<DreamDataBody>? = null,
    val id: String? = null,
)

data class UserFinanceBody(
    val income: IncomeBody? = null,
    val expenses: ExpensesBody? = null,
    val paymentCapability: Double? = null,
)

data class IncomeBody(
    val type: String?  = null,
    val amount: Double?  = null,
    val frequency: String?  = null,
    val additionalIncomeAmount: Double?  = null,
    val totalIncome: Double?  = null,
)

data class ExpensesBody(
    val home: Double?  = null,
    val transport: Double?  = null,
    val education: Double?  = null,
    val hobby: Double?  = null,
    val loanOrCredit: Double?  = null,
    val totalExpense: Double?  = null,
)

data class DreamDataBody(
    val description: String ?= null,
    val amount: String?  = null,
    val date: String?  = null,
    val amountPlaned: Double?  = null,
    val paymentQuantity: Double?  = null,
    val dreamType: DreamTypeBody?  = null,
)

data class DreamTypeBody(
     val id: String
)
