package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.planeando_suenos.ui.main.MainViewModel


@Composable
fun Router(mainModel: MainViewModel) {

    val navController = rememberNavController()

    val state = mainModel.state

    val login = state.login

    if (login == null) {
        PublicRouter(navController,mainModel)
    }
    else {
        UserRouter(navController,mainModel)
    }
}


