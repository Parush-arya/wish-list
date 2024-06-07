package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(var route: String) {
    object HomeScreen : Screen("HomeScreen")
    object AddScreen : Screen("AddScreen")
}

@Composable
fun Navigation(viewModel: WishViewModel) {
    var navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController, viewModel)
        }
        composable(Screen.AddScreen.route) {
            AddEditScreen(id.toLong(), navController, viewModel)
        }
    }
}