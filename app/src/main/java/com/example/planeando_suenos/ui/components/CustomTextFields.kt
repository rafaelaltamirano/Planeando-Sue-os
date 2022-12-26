package com.example.planeando_suenos.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.ui.theme.BackgroundCard
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
    onDone: (() -> Unit)? = null,
    @StringRes placeholder: Int? = null,
    @DrawableRes leadingIcon: Int? = null,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val showLeadingIcon = leadingIcon != null

    OutlinedTextField(
        modifier = modifier.background(BackgroundCard, shape = RoundedCornerShape(8.dp)),
        leadingIcon = if (showLeadingIcon) {
            {
                Icon(
                    painter = painterResource(id = leadingIcon!!),
                    contentDescription = "",
                    tint = GreenBusiness
                )
            }
        } else null,
        value = value,
        textStyle = MaterialTheme.typography.caption,
        onValueChange = onValueChanged,
        placeholder = {
            placeholder?.let {
                Text(
                    text = stringResource(it),
                    style = MaterialTheme.typography.caption,
                )
            }
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = GreenBusiness,
            unfocusedBorderColor = GrayBusiness,
            textColor = TextBusiness,
            cursorColor = TextBusiness
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (security) KeyboardType.Password else keyboardType,
            imeAction = if (onDone == null) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDone?.invoke() }),
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
