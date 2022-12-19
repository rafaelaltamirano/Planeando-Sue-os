package com.example.planeando_suenos.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W200
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    security: Boolean = false,
    @StringRes placeholder: Int? = null,
    @DrawableRes leadingIcon: Int? = null,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        textStyle = MaterialTheme.typography.caption,
        onValueChange = onValueChanged,
        placeholder = {
            placeholder?.let {
                Text(
                    stringResource(it),
                    style = MaterialTheme.typography.caption,
                )
            }
        },
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            leadingIcon?.let {
                Icon(painterResource(it), "leadingIcon")
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = GreenBusiness,
            unfocusedBorderColor = GrayBusiness,
            textColor = TextBusiness,
            cursorColor = TextBusiness
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (security) KeyboardType.Password else keyboardType,
        ),
        visualTransformation = if (!security) {
            VisualTransformation.None
        } else {
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        },
        trailingIcon = {
            if (security) {
                val imageIcon =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = imageIcon, contentDescription = "")
                }
            }
        },
    )
}
