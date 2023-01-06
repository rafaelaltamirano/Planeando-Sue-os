package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun SubmitButton(
    text: String = "",
    onClick: () -> Unit,
    color: Color = GreenBusiness,
    loading: Boolean = false,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(R.dimen.gap4),
            horizontal = dimensionResource(R.dimen.gap5))
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        enabled = enabled && !loading,
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(
            vertical = 13.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            disabledBackgroundColor = Gray
        ),
    ) {
        when (loading) {
            true -> {

                CircularProgressIndicator(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    color = White
                )
            }
            else -> {
                Text(
                    text.uppercase(),
                    color = White,
                    style = MaterialTheme.typography.button,
                    fontWeight = W900
                )
            }
        }
    }
}