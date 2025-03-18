package com.example.fineduca.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavHostController
import com.example.fineduca.R
import com.example.fineduca.components.DarkButton
import com.example.fineduca.components.LightButton

@Composable
fun MainScreen(navController: NavHostController) {
    val backgroundImage = painterResource(id = R.drawable.home_image)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Home Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 16.dp, end = 16.dp, bottom = 140.dp, start = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "FinEduca\n",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = "Simplificando as Finanças\n",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 40.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DarkButton("Cadastre-se", modifier = Modifier.width(150.dp)) {
                    // Navega para a tela de cadastro e remove a tela anterior da pilha
                    navController.navigate("register_screen") {
                        // PopUp da tela anterior e volta para a tela de login
                        popUpTo("main_screen") { inclusive = true }
                        launchSingleTop = true // Evita múltiplas instâncias da tela
                    }
                }
                LightButton("Acessar", modifier = Modifier.width(150.dp)) {
                    // Navega para a tela de login e remove a tela anterior da pilha
                    navController.navigate("login_screen") {
                        // PopUp da tela anterior e volta para a tela de login
                        popUpTo("main_screen") { inclusive = true }
                        launchSingleTop = true // Evita múltiplas instâncias da tela
                    }
                }
            }
        }
    }
}
