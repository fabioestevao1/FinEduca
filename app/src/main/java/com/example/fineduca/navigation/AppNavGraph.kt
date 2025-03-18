package com.example.fineduca.navigation

import LoginScreen
import PasswordScreen
import RegisterScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {
    // Remova esta linha, pois você já recebe o navController como parâmetro
    // val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("login_screen") {
            LoginScreen(navController)
        }
        composable("register_screen") {
            RegisterScreen(
                navController = navController,
            )
        }
        composable("home_screen") { HomeScreen(navController) }
        composable("profile_screen") { ProfileScreen(navController) }
        composable("password_screen") { PasswordScreen(navController) }
        composable("config_screen") { ConfigScreen(navController) }
        composable("quotation_screen") { QuotationScreen(navController) }
        composable("investment_simulation_screen") { InvestmentSimulation(navController) }
        composable("information_screen") { InformationScreen(navController) }
    }
}