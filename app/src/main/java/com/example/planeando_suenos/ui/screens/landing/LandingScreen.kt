package com.example.planeando_suenos.ui.screens.landing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.PresentationCard
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.theme.GreenBusiness


@Composable
fun LandingScreen(
    mainModel: MainViewModel,
    model: LandingViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.gap4)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        PresentationCard(R.string.password, White)
        Row(
            Modifier.padding(
                start = dimensionResource(R.dimen.gap5),
                end = dimensionResource(R.dimen.gap5),
                top = dimensionResource(R.dimen.gap5)
            )
        ) {
            Text(
                text = stringResource(R.string.lading_instructions),
                style = MaterialTheme.typography.h4,
                color = Black,
                fontSize = 18.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.gap5))
        ) {
            Text(
                text = stringResource(R.string.you_are_ready),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = Black,
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
        }
        SubmitButton(
            text = stringResource(R.string.crate_account),
            onClick = { navController.navigate(PublicRouterDir.REGISTER.route) }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.gap5)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(R.string.already_have_account),
                color = Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 4.dp),
                style = MaterialTheme.typography.caption,
            )

            Text(
                stringResource(R.string.sign_in),
                color = GreenBusiness,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.clickable(onClick = { navController.navigate(PublicRouterDir.LOGIN.route) }),
                textDecoration = TextDecoration.Underline
            )
        }

    }
}