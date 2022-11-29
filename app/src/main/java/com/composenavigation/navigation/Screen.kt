package com.composenavigation.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object HomeScreen : Screen("home_screen")
    object ChatScreen : Screen("chat_screen")
    object SettingsScreen : Screen("settings_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("?name=/$arg")
            }
        }
    }
}
