package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness

val completeColor = GreenBusiness
val defaultColor = GrayBusiness

@Composable
fun StepsProgressBar(
    modifier: Modifier = Modifier,
    numberOfSteps: Int = 3,
    currentStep: Int,
    onBackPress: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(White),
        title = {

            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
            ) {
                for (step in 0..numberOfSteps) {
                    Step(
                        isComplete = step < currentStep,
                        isCurrent = step == currentStep,
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_progress_bar),
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
    )

}

@Composable
fun Step(
    isCurrent: Boolean,
    isComplete: Boolean,
) {

    if (isComplete || isCurrent) {
        Divider(
            modifier = Modifier.width(40.dp),
            color = completeColor,
            thickness = 3.dp
        )
    } else {
        Divider(
            modifier = Modifier.width(40.dp),
            color = defaultColor,
            thickness = 3.dp
        )
    }

}

@Preview
@Composable
private fun StepsProgressBarPreview() {
    StepsProgressBar(
        modifier = Modifier.fillMaxWidth(),
        numberOfSteps = 3,
        currentStep = 0,
        onBackPress = {}

    )
}

