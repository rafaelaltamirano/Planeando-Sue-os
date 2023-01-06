package com.example.planeando_suenos.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.planeando_suenos.ui.theme.BackgroundCard
import com.example.planeando_suenos.ui.theme.GrayBusiness
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CurrencyTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Number,
    onDone: Boolean = false,
    @StringRes placeholder: Int? = null,
    @DrawableRes leadingIcon: Int? = null,
) {
    val showLeadingIcon = leadingIcon != null
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val decimalPatter = remember { Regex("^\\d*\\.?\\d*\$") }

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
        value = if(value != "null")  value else "",
        textStyle = MaterialTheme.typography.caption,
        onValueChange = {
            if (it.isEmpty() || it.matches(decimalPatter) ) {
                 if (it.isEmpty() || it.matches(decimalPatter) && !(value == "null" && it ==".")) {
                    onValueChanged(it)
                }
            }
        }
        ,
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
            keyboardType = keyboardType,
            imeAction = if (!onDone) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        visualTransformation = VisualTransformation.None,
    )

}