package com.example.planeando_suenos.ui.router

enum class PublicRouterDir (override val route: String) : Routers {
    LOGIN("login"),
    REGISTER("register"),
    LANDING("landing"),
    RESTORE_PASS("restorePass");
}