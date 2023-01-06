package com.example.planeando_suenos.domain.body.smartShopping

data class DreamPlan(
    val title: String? = null,
    val userFinance: UserFinance? = null,
    val dream: List<Dream>? = null,
    val id: String? = null,
)

data class UserFinance(
    val income: Income? = null,
    val expenses: Expenses? = null,
    val paymentCapability: Float? = null,
)

data class Income(
    val type: String?  = null,
    val amount: Double?  = null,
    val frequency: String?  = null,
    val additionalIncomeAmount: Double?  = null,
    val totalIncome: Double?  = null,
    val amountPerDay: Double?  = null,

)

data class Expenses(
    val home: Float?  = null,
    val transport: Float?  = null,
    val education: Float?  = null,
    val hobby: Float?  = null,
    val loanOrCredit: Float?  = null,
    val totalExpense: Float?  = null,
    val loanOrCreditPaymentDate: String?  = null,
    val amountPerDay: Float?  = null,
)

data class Dream(
    val description: String ?= null,
    val amount: Float?  = null,
    val startDate: String?  = null,
    val endDate: String?  = null,
    val amountPlaned: Float?  = null,
    val paymentQuantity: Float?  = null,
    val dreamType: DreamType?  = null,
)

data class DreamType(
    val id: String?  = null,
    val title: String?  = null,
    val iconName: String? = null,
)