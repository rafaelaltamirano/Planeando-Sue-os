package com.example.planeando_suenos.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Router() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routers.MAIN.route){

    }
}