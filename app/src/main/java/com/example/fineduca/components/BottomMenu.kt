package com.example.fineduca.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fineduca.R
import com.example.fineduca.ui.theme.MainBlue
import com.example.fineduca.ui.theme.MainGreen

@Composable
fun BottomMenu(modifier: Modifier, navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }

    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Share,
        Icons.Filled.AccountCircle,
        Icons.Filled.Settings
    )

    val iconTitles = listOf("Home", "Quotation", "Account", "Settings")

    val routes = listOf(
        "home_screen",
        "quotation_screen",
        "profile_screen",
        "config_screen"
    )

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val route = backStackEntry.destination.route
            val index = routes.indexOf(route)
            if (index != -1) {
                selectedItem = index
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MainBlue),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icons.forEachIndexed { index, icon ->
            IconButton(
                onClick = {
                    selectedItem = index
                    navController.navigate(routes[index])
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = iconTitles[index],
                    tint = if (selectedItem == index) MainGreen else Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}