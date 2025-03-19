package com.example.fineduca.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fineduca.R
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TextBox
import com.example.fineduca.components.TopMenu

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
    ) {
        // Menu superior
        Spacer(modifier = Modifier.height(40.dp))
        TopMenu()
        Spacer(modifier = Modifier.height(20.dp))

        // Conteúdo principal
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBox(
                title = "Cotações",
                text = "Acompanhe aqui as Cotações das Principais Moedas e Ações do Mundo",
                onClick = { navController.navigate("quotation_screen") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Simulação de Investimentos",
                text = "Descubra quanto você pode ter no futuro se começar a investir hoje",
                onClick = { navController.navigate("investment_simulation_screen") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Aprenda Aqui !",
                text = "Aumente o seu Conhecimento em Finanças",
                onClick = { navController.navigate("information_screen") }
            )

        }

        // Menu inferior
        BottomMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), navController
        )
    }
}