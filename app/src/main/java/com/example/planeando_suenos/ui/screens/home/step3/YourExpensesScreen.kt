package com.example.planeando_suenos.ui.screens.home.step3

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.StepsProgressBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.step2.Step2Step
import com.example.planeando_suenos.ui.screens.home.step3.creditAmount.CreditAmountStep
import com.example.planeando_suenos.ui.screens.home.step3.expensesConfirmation.ExpensesConfirmationStep
import com.example.planeando_suenos.ui.screens.home.step3.frequencyExpenses.FrequencyExpensesStep
import com.example.planeando_suenos.ui.screens.home.step3.creditQuestion.CreditQuestionStep

@Composable
fun YourExpensesScreen(
    model: YourExpensesIncomeViewModel,
    mainModel: MainViewModel,
    navController: NavHostController
) {

    val state = model.state

    BackHandler(enabled = true) {
        if (state.step == Step3Step.FREQUENCY_EXPENSES) navController.popBackStack()
        else model.prevStep()
    }

    Scaffold(
        topBar = {
            if (state.step != Step3Step.CONFIRMATION) StepsProgressBar(
                numberOfSteps = Step2Step.values().size - 2,
                currentStep = state.step.step,
                onBackPress = {
                    if (state.step == Step3Step.FREQUENCY_EXPENSES) navController.popBackStack()
                    else model.prevStep()
                }
            )
        },
        backgroundColor = Color.White,
    ) {
        when (state.step) {
            Step3Step.FREQUENCY_EXPENSES -> FrequencyExpensesStep(
                onNext = model::nextStep,
            )
            Step3Step.CREDIT_QUESTION -> CreditQuestionStep(
                onNext = model::nextStep,
            )
            Step3Step.CREDIT_AMOUNT -> CreditAmountStep(
                onNext = model::nextStep,
            )
            Step3Step.CONFIRMATION -> ExpensesConfirmationStep(
                onNext = { navController.navigate(UserRouterDir.HOME.route) },
            )
        }
    }
}