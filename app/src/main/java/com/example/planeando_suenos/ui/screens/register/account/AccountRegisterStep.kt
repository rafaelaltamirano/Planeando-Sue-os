package com.example.planeando_suenos.ui.screens.register.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

@Composable
fun AccountRegisterStep(
    onNext: () -> Unit
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
            text = "Correo electronico"
        )
        CustomTextField(
            value = "email_user@gmail",
            leadingIcon = R.drawable.ic_arrouba,
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            text = "Contraseña"
        )
        CustomTextField(
            value = "***********",
            security = true,
            leadingIcon = R.drawable.ic_lock,
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            text = "Repetir contraseña"
        )
        CustomTextField(
            value = "***********",
            security = true,
            leadingIcon =R.drawable.ic_lock,
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4) )
        )

        SubmitButton(
            text = "next",
            onClick = { onNext() }
        )
    }


}
