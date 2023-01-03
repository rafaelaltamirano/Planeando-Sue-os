package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.*
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName

class DreamPlanResponse(
    @SerializedName("title") val title: String,
    @SerializedName("userFinance") val userFinance: UserFinanceResponse,
    @SerializedName("dream") val dream: List<DreamResponse>,
    @SerializedName("id") val id: String,
) : Response<DreamPlan> {
    override fun toEntity() = DreamPlan(
        title = title,
        userFinance = userFinance.toEntity(),
        dream = dream.map { it.toEntity() },
        id = id
    )
}

class UserFinanceResponse(
    @SerializedName("income") val income: IncomeResponse,
    @SerializedName("expenses") val expenses: ExpensesResponse,
    @SerializedName("paymentCapability") val paymentCapability: Double,
) : Response<UserFinance> {
    override fun toEntity() = UserFinance(
        income = income.toEntity(),
        expenses = expenses.toEntity(),
        paymentCapability = paymentCapability,
    )
}

data class IncomeResponse(
    @SerializedName("type") val type: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("frequency") val frequency: String,
    @SerializedName("aditionalIncomeAmount") val additionalIncomeAmount: Double,
    @SerializedName("totalIncome") val totalIncome: Double,
) : Response<Income> {
    override fun toEntity() = Income(
        type = type,
        amount = amount,
        frequency = frequency,
        additionalIncomeAmount = additionalIncomeAmount,
        totalIncome = totalIncome,
    )
}

data class ExpensesResponse(
    @SerializedName("home") val home: Double,
    @SerializedName("transport") val transport: Double,
    @SerializedName("education") val education: Double,
    @SerializedName("hobby") val hobby: Double,
    @SerializedName("loanOrCredit") val loanOrCredit: Double,
    @SerializedName("totalExpense") val totalExpense: Double,
) : Response<Expenses> {
    override fun toEntity() = Expenses(
        home = home,
        transport = transport,
        education = education,
        hobby = hobby,
        loanOrCredit = loanOrCredit,
        totalExpense = totalExpense
    )
}

data class DreamResponse(
    @SerializedName("description") val description: String,
    @SerializedName("amount") val amount: Float,
    @SerializedName("date") val date: String,
    @SerializedName("amountPlaned") val amountPlaned: Float,
    @SerializedName("paymentQuantity") val paymentQuantity: Float,
    @SerializedName("dreamType") val dreamType: DreamTypeResponse,
) : Response<Dream> {
    override fun toEntity() = Dream(
        description = description,
        amount = amount,
        date = date,
        amountPlaned = amountPlaned,
        paymentQuantity = paymentQuantity,
        dreamType = dreamType.toEntity()
    )
}

