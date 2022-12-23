package com.example.planeando_suenos.ui.screens.restorePass.finish

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithCheck
import com.example.planeando_suenos.ui.screens.restorePass.RestorePasswordViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextBusiness


@Composable
fun FinishStep(
    onNext: () -> Unit,
    model: RestorePasswordViewModel
) {
    Column {
        TopBarWithCheck()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.gap5)),
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.password_restored),
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold,
                    color = TextBusiness,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(Modifier.height(dimensionResource(R.dimen.gap6)))
            Text(
                text = stringResource(R.string.your_pass_has_been_restore),
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Bold,
                color = GreenBusiness,
                textAlign = TextAlign.Start,
                fontSize = 22.sp
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap6)))
            Text(
                text = stringResource(R.string.click_button),
                fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap6)))
            SubmitButton(
                stringResource(R.string.enter),
                onClick = onNext
            )
        }
    }
}

