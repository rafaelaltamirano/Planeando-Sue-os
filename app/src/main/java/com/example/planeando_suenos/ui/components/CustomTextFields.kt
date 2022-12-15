package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    placeHolder: @Composable () -> Unit,
    leadingIcon: @Composable () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value, onValueChange = { onValueChanged(it) },
        modifier = modifier,
        placeholder = placeHolder,
        singleLine = true,
        maxLines = 1,
        leadingIcon = leadingIcon,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = GreenBusiness,
            unfocusedBorderColor = GrayBusiness,
            textColor = TextBusiness,
            cursorColor = TextBusiness
        ),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    CustomTextField(
        value = value,
        onValueChanged = { onValueChanged(it) },
        leadingIcon = { Icon(imageVector = Icons.Filled.Password, contentDescription = "") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeHolder = { Text(text = stringResource(id = R.string.password)) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val imageIcon =
                if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = imageIcon, contentDescription = "")
            }
        }
    )
}