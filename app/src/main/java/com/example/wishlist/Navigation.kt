package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
        composable(
            Screen.AddScreen.route + "/{id}",
            arguments = listOf(navArgument("id", builder = { type = NavType.LongType }))
        ) {
            val id = if (it.arguments != null) it.arguments!!.getLong("id") else 0L
            AddEditScreen(id, navController, viewModel)
        }
    }
}