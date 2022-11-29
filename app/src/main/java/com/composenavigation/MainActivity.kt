package com.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.compose.rememberNavController
import com.composenavigation.navigation.BottomNavigationBar
import com.composenavigation.navigation.Navigation
import com.composenavigation.navigation.Screen
import com.composenavigation.navigation.model.BottomNavBarItem
import com.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavBarItem(
                                    name = "Home",
                                    route = Screen.HomeScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavBarItem(
                                    name = "Chat",
                                    route = Screen.ChatScreen.route,
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 54
                                ),
                                BottomNavBarItem(
                                    name = "Settings",
                                    route = Screen.SettingsScreen.route,
                                    icon = Icons.Default.Settings,
                                    badgeCount = 3
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}
