package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Otp(
    modifier: Modifier,
    onValueChange: (String) -> Unit
) {
    var otp1 by rememberSaveable { mutableStateOf("") }
    var otp2 by rememberSaveable { mutableStateOf("") }
    var otp3 by rememberSaveable { mutableStateOf("") }
    var otp4 by rememberSaveable { mutableStateOf("") }

    val (item1, item2, item3, item4) = remember { FocusRequester.createRefs() }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier.padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            modifier = Modifier
                .size(50.dp)
                .focusRequester(item1)
                .background(color = Color.White),
            value = otp1,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = {
                if (it.length == 1) {
                    otp1 = it
                    item2.requestFocus()
                } else {
                    otp1 = ""
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFFD8E2F3)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .size(50.dp)
                .focusRequester(item2)
                .background(color = Color.White),
            value = otp2,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFFD8E2F3)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = {
                if (it.length == 1) {
                    otp2 = it
                    item3.requestFocus()
                } else {
                    otp2 = ""
                }
            },
        )
        OutlinedTextField(
            modifier = Modifier
                .size(50.dp)
                .focusRequester(item3)
                .background(color = Color.White),
            value = otp3,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFFD8E2F3)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = {
                if (it.length == 1) {
                    otp3 = it
                    item4.requestFocus()
                } else {
                    otp3 = ""
                }
            },
        )
        OutlinedTextField(
            modifier = Modifier
                .size(50.dp)
                .focusRequester(item4)
                .background(color = Color.White),
            value = otp4,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFFD8E2F3)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Go
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = {
                if (it.length == 1) {
                    otp4 = it
                    onValueChange(otp1 + otp2 + otp3 + otp4)
                    focusManager.clearFocus()
                } else {
                    otp4 = ""
                }
            },
        )
    }

}

@Preview
@Composable
fun PrevOtp() {
    Column {
        Otp(modifier = Modifier.fillMaxWidth(), onValueChange = {})
        Spacer(modifier = Modifier.size(50.dp))

    }
}