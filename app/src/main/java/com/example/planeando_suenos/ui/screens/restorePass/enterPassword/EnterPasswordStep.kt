package com.example.planeando_suenos.ui.screens.restorePass.enterPassword

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.ValidatorMessage
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordViewModel

@Composable
fun EnterPasswordStep(
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
            text = stringResource(R.string.pass_should_be_different),
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap6)))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.password)
        )
        CustomTextField(
            value = "123abcd..",
            placeholder = R.string.password_example,
            security = true,
            leadingIcon = R.drawable.ic_lock,
            onValueChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        ValidatorMessage("Mínimo 8 caracteres", null)
        ValidatorMessage("Al menos un número (0-9) o símbolo", null)
        ValidatorMessage("Minúscula (a-z) y mayúscula(A-Z)", null)
        Spacer(Modifier.height(10.dp))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.repeat_pass)
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap2)))

        CustomTextField(
            value = "123abcd..",
            placeholder = R.string.password_example,
            security = true,
            leadingIcon = R.drawable.ic_lock,
            onValueChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

        SubmitButton(
            stringResource(R.string.reset),
            onClick = onNext,
        )
    }
}

