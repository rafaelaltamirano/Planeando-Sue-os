package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.*
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName

class UserFinanceResponse(
    @SerializedName("income") val income: IncomeResponse,
    @SerializedName("expenses") val expenses: ExpensesResponse,
    @SerializedName("paymentCapability") val paymentCapability: Float,
) : Response<UserFinance> {
    override fun toEntity() = UserFinance(
        income = income.toEntity(),
        expenses = expenses.toEntity(),
        paymentCapability = paymentCapability,
    )
}

data class IncomeResponse(
    @SerializedName("type") val type: String,
    @SerializedName("amount") val amount: Float,
    @SerializedName("frequency") val frequency: String,
    @SerializedName("additionalIncomeAmount") val additionalIncomeAmount: Float,
    @SerializedName("totalIncome") val totalIncome: Float,
    @SerializedName("amountPerDay") val amountPerDay: Float,
) : Response<Income> {
    override fun toEntity() = Income(
        type = type,
        amount = amount,
        frequency = frequency,
        additionalIncomeAmount = additionalIncomeAmount,
        totalIncome = totalIncome,
        amountPerDay = amountPerDay
    )
}

data class ExpensesResponse(
    @SerializedName("home") val home: Float,
    @SerializedName("transport") val transport: Float,
    @SerializedName("education") val education: Float,
    @SerializedName("hobby") val hobby: Float,
    @SerializedName("loanOrCredit") val loanOrCredit: Float,
    @SerializedName("loanOrCreditPaymentDate") val loanOrCreditPaymentDate: String,
    @SerializedName("totalExpense") val totalExpense: Float,
    @SerializedName("amountPerDay") val amountPerDay: Float,
) : Response<Expenses> {
    override fun toEntity() = Expenses(
        home = home,
        transport = transport,
        education = education,
        hobby = hobby,
        loanOrCredit = loanOrCredit,
        totalExpense = totalExpense,
        loanOrCreditPaymentDate = loanOrCreditPaymentDate,
        amountPerDay = amountPerDay
    )
}

data class DreamResponse(
    @SerializedName("description") val description: String,
    @SerializedName("amount") val amount: Float,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("endDate") val endDate: String,
    @SerializedName("amountPlaned") val amountPlaned: Float,
    @SerializedName("paymentQuantity") val paymentQuantity: Float,
    @SerializedName("dreamType") val dreamType: DreamTypeIdResponse,
    @SerializedName("color") val color: String,
) : Response<Dream> {
    override fun toEntity() = Dream(
        description = description,
        amount = amount,
        startDate = startDate,
        endDate = endDate,
        amountPlaned = amountPlaned,
        paymentQuantity = paymentQuantity,
        dreamType = dreamType.toEntity(),
        color = color
    )
}

