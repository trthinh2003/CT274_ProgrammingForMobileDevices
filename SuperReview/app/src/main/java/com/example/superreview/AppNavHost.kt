package com.example.superreview

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.superreview.ui.theme.BookingViewModel

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val dsPhong: BookingViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = "HOME_SCREEN"
    ) {
        composable(route = "HOME_SCREEN") {
            HomeScreen(navController, dsPhong)
        }
        composable(
            route = "DETAIL_ROOM/{idPhong}",
            arguments = listOf(
                navArgument("idPhong") {
                    type = NavType.IntType
                }
            )
        ) {
            backStackEntry ->
            val idPhong = backStackEntry.arguments?.getInt("idPhong")
            DetailRoom(navController, dsPhong, idPhong?:0)
        }
        composable(
            route = "PAYMENT/{idPhong}/{soLuongDat}",
            arguments = listOf(
                navArgument("idPhong") {
                    type = NavType.IntType
                },
                navArgument("soLuongDat") {
                    type = NavType.StringType
                }
            )
        ) {
            backStackEntry ->
            val idPhong = backStackEntry.arguments?.getInt("idPhong")
            val soLuongDat = backStackEntry.arguments?.getString("soLuongDat")
            PayMent(navController, dsPhong, idPhong?:0, soLuongDat?:"")
        }
    }
}