package com.example.planeando_suenos.ui.screens.restorePass.enterEmail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordViewModel


@Composable
fun EnterEmailStep(
    onNext: () -> Unit,
    model: RestorePasswordViewModel,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(R.dimen.gap5)),
    ) {

        Text(
            text = stringResource(R.string.not_worry),
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap6)))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.email)
        )

        CustomTextField(
            value = model.state.email,
            placeholder = R.string.email_example,
            leadingIcon = R.drawable.ic_arrouba,
            onValueChanged = model::setEmail,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))
        SubmitButton(
            stringResource(R.string.send),
            onClick = onNext,
        )
    }
}

