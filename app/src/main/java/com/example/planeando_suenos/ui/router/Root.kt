package com.example.planeando_suenos.ui.router

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.planeando_suenos.ui.components.TopBar
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun Root(
    navController: NavController,
    mainModel: MainViewModel,
    child: @Composable () -> Unit
) {

    var route by remember { mutableStateOf(navController.currentDestination?.route ?: "login") }

    val scaffoldState = rememberScaffoldState()

    navController.addOnDestinationChangedListener { _, destination, _ ->
        destination.route?.also { route = it }
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Scaffold(
            topBar = { TopBar("title","subtitle", onBackPress = {}) },
            backgroundColor = White,
        ) {
            child()
        }
    }
}