package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun GenericErrorDialog(
    show: Boolean = false,
    title: String = "",
    onDismiss: () -> Unit
) {

    if (!show) return
    else {
        Dialog(
            onDismissRequest = {
                onDismiss()
            }) {
            Card(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                contentColor = White
            ) {

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.gap4)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.gap4)),
                        text = title,
                        color = GreenBusiness,
                        style = MaterialTheme.typography.h1,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700
                    )


                    SubmitButton(
                        onClick = {
                            onDismiss()
                        },
                        text = "cerrar",
                        modifier = Modifier
                            .height(55.dp)
                            .fillMaxWidth()
                            .padding(
                                vertical = dimensionResource(R.dimen.gap3),
                                horizontal = dimensionResource(R.dimen.gap6)
                            )
                    )
                }
            }
        }
    }
}
