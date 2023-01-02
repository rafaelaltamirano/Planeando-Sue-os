package com.example.planeando_suenos.domain.entities

class DreamPlan(
    val title: String,
    val userFinance: UserFinance,
    val dream: List<Dream>,
    val id: String,
)

class UserFinance(
    val income: Income,
    val expenses: Expenses,
    val paymentCapability: Double,
)

data class Income(
    val type: String,
    val amount: Double,
    val frequency: String,
    val additionalIncomeAmount: Double,
    val totalIncome: Double,
)

data class Expenses(
    val home: Double,
    val transport: Double,
    val education: Double,
    val hobby: Double,
    val loanOrCredit: Double,
    val totalExpense: Double,
)

data class Dream(
    val description: String,
    val amount: Double,
    val date: String,
    val amountPlaned: Double,
    val paymentQuantity: Double,
    val dreamType: DreamType,
)

