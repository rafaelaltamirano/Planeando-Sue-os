package com.example.planeando_suenos.ui.screens.register.data

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TextDate
import com.example.planeando_suenos.ui.screens.register.RegisterViewModel


@Composable
fun DataRegisterStep(
    onSubmit: () -> Unit,
    model: RegisterViewModel
) {

    val state = model.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.gap4))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.your_data),
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontSize = 18.sp
        )
        Spacer(Modifier.height(10.dp))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.name)
        )
        CustomTextField(
            value = state.name,
            placeholder = R.string.name_example,
            onValueChanged = model::setName,
            leadingIcon = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.father_surname)
        )
        CustomTextField(
            value = state.surname,
            placeholder = R.string.surname_example,
            leadingIcon = null,
            onValueChanged = model::setSurname,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.mother_surname)
        )
        CustomTextField(
            value = state.motherSurname,
            placeholder = R.string.optional,
            onValueChanged = model::setMotherName,
            leadingIcon = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.born_day)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextDate(onValueChanged = model::setBornDay)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.phone)
        )
        CustomTextField(
            value = state.phone,
            placeholder = R.string.phone_example,
            onValueChanged = model::setPhone,
            leadingIcon = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = stringResource(R.string.pc_address)
        )
        CustomTextField(
            value = state.cp,
            placeholder = R.string.address_example,
            onValueChanged = model::setCp,
            onDone = true,
            keyboardType = KeyboardType.Number,
            onFocus = model::setCpError,
            error = state.cpError,
            leadingIcon = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )

        if(state.cp.length!=5 && state.cp.isNotEmpty())  model.setCpError(stringResource(R.string.cp_should_have))
        else model.setCpError("")

        SubmitButton(
            enabled = state.name!= "" && state.surname!= "" && state.phone!= "" && state.cp!= "" && state.cpError =="" && state.bornDay != "",
            text = stringResource(R.string.continue_),
            onClick = onSubmit
        )
    }
}
