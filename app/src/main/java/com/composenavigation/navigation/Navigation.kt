package com.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.composenavigation.composable.*

@Composable
fun Navigation(navController: NavHostController) {


    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            //Mention that we add arguments in url style,
            // if we want to add default we do - "?name=/{name}"
            // or use help fun in sealed Screen class fun withArgs()
            // without default we do - "/{name}"
            route = Screen.DetailScreen.route + "?name=/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Asya"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen()
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}