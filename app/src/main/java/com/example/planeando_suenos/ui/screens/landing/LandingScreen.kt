package com.example.planeando_suenos.ui.screens.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.OutlineSubmitButton
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
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopBarWithComponentLanding()
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.gap4)),
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.gap4)))
            Row(
                Modifier.padding(
                    horizontal = dimensionResource(R.dimen.gap5),
                )
            ) {
                Text(
                    text = stringResource(R.string.lading_instructions),
                    style = MaterialTheme.typography.h4,
                    color = Black,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.gap4)))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.gap5))
            ) {
                Text(
                    text = stringResource(R.string.legals),
                    style = TextStyle(fontStyle = FontStyle.Italic),
                    fontWeight = FontWeight.ExtraLight,
                    letterSpacing = 1.sp,
                    color = Black,
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.gap4)))
            SubmitButton(
                text = stringResource(R.string.register),
                onClick = { navController.navigate(PublicRouterDir.REGISTER.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(R.dimen.gap2),
                        horizontal = dimensionResource(R.dimen.gap5)
                    )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.gap5)),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "o",
                    color = Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                )
            }
            OutlineSubmitButton(
                text = stringResource(R.string.sign_in),
                onClick = { navController.navigate(PublicRouterDir.LOGIN.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(R.dimen.gap2),
                        horizontal = dimensionResource(R.dimen.gap5)
                    )
            )
        }
    }
}

@Composable
fun TopBarWithComponentLanding() {
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(GreenBusiness)
        ) {
            Text(
                text = "Planeando \nsue??os",
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp),
                color = White,
                style = MaterialTheme.typography.h3,
                fontWeight = W900
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.gap4)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(110.dp)
                    .width(10.dp)
            )
            PresentationCard(R.string.password, White)
        }
    }
}