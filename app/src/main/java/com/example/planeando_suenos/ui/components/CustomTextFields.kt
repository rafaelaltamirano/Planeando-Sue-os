package com.example.planeando_suenos.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    security: Boolean = false,
    onDone: Boolean = false,
    @StringRes placeholder: Int? = null,
    @DrawableRes leadingIcon: Int? = null,
    error: String? = null,
    onFocus: (() -> Unit)? = null,

) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val showLeadingIcon = leadingIcon != null
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier =  modifier
            .fillMaxWidth()
            .background(BackgroundCard, shape = RoundedCornerShape(8.dp))
            .onFocusChanged(
                onFocusChanged = {
                    when (it.isFocused) {
                        true -> onFocus?.invoke()
                        else -> {}
                    }
                }
            ),
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
        isError = !error.isNullOrBlank(),
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
            imeAction = if (!onDone) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        visualTransformation =
            if (!security) {
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
    InputMessageError(error)

}


@Composable
fun InputMessageError(message: String?) {
    if (!message.isNullOrEmpty())
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.gap4))
        ) {
            Text(
                text = message,
                color = Danger,
                style = MaterialTheme.typography.caption,
                fontSize = 11.sp
            )
        }
}
