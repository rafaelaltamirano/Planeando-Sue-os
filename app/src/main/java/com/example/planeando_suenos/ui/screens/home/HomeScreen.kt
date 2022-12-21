package com.example.planeando_suenos.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.planeando_suenos.ui.components.CardChecked
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.theme.GreenBusiness


@Composable
fun HomeScreen(model: HomeViewModel, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopBarWithComponent()

        Column(
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                )
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Somos los aliados de tus sueños. Para ayudarte a planfificar tu compra debemos conocer un poco mas sobre:",
                fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Paso 1",
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = true,
                title = "Tus sueños y aspiraciones",
                subTitle = "Datos completados con éxito",
                onClick = { navController.navigate(UserRouterDir.STEP_1.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Paso 2",
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = true,
                title = "Tus ingresos aproximados",
                subTitle = "$ 1.600.00 semanales",
                onClick = { navController.navigate(UserRouterDir.STEP_3.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Paso 3",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            CardChecked(
                checked = false,
                title = "Tus egresos o gastos",
                subTitle = "$ 861.40 semanales",
                onClick = {navController.navigate(UserRouterDir.STEP_3.route)}
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Es fácil y rápido. ¿Estás listo?",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun TopBarWithComponent() {
    Box {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(GreenBusiness)
        ) {
            Text(
                text = "Planeando sueños",
                modifier = Modifier.padding(start = 24.dp, top = 16.dp),
                color = Color.White
            )
        }
        Column {
            Spacer(
                modifier = Modifier
                    .height(70.dp)
                    .width(10.dp)
            )
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(6.dp),
                elevation = 4.dp
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "¡Hola Julian!",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 17.sp
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    TopBarWithComponent()
}