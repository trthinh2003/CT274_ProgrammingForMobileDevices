package com.example.lab4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable("${NavigationItem.Home.route}/{username}/{password}", arguments = listOf(
            navArgument("username") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("password") {
                type = NavType.StringType
            }
        )) {
            backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            val password = backStackEntry.arguments?.getString("password")
            Page2(NhanVienModel(username?:"", password?:""))
        }
    }
}