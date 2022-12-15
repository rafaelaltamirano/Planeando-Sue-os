package com.example.planeando_suenos.ui.screens.landing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.router.PublicRouterDir


@Composable
fun LandingScreen(
    mainModel: MainModel,
    model: LandingModel,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Landing",
            style = MaterialTheme.typography.h2,
            color = Color.Black
        )
        Text(
            "Sign Up",
            color = Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.clickable(onClick = { navController.navigate(PublicRouterDir.REGISTER.route) }),
            textDecoration = TextDecoration.Underline
        )

        Text(
            "Login",
            color = Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.clickable(onClick = { navController.navigate(PublicRouterDir.LOGIN.route) }),
            textDecoration = TextDecoration.Underline
        )



    }
}