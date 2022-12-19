package com.example.planeando_suenos.ui.screens.register.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.ValidatorMessage
import com.example.planeando_suenos.ui.screens.register.RegisterViewModel

@Composable
fun AccountRegisterStep(
    onNext: () -> Unit,
    model: RegisterViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.gap4)),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Tu cuenta",
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
            text = "Correo electronico"
        )
        CustomTextField(
            value = model.state.email,
            placeholder = R.string.email_example,
            leadingIcon = R.drawable.ic_arrouba,
            onValueChanged =  model::setEmail,
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Contraseña"
        )
        CustomTextField(
            value = model.state.password,
            placeholder = R.string.password,
            security = true,
            leadingIcon = R.drawable.ic_lock,
            onValueChanged = model::setPassword,
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )
        ValidatorMessage("Mínimo 8 caracteres",model.state.validCharacter)
        ValidatorMessage("Al menos un número (0-9) o símbolo",model.state.validMayus)
        ValidatorMessage("Minúscula (a-z) y mayúscula(A-Z)",model.state.validNumber)
        Spacer(Modifier.height(10.dp))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Repetir contraseña"
        )
        CustomTextField(
            value = "***********",
            placeholder = R.string.email_example,
            security = true,
            leadingIcon =R.drawable.ic_lock,
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )

        SubmitButton(
            text = "Next",
            onClick = { onNext() }
        )
    }


}
