package com.example.fineduca.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.fineduca.R
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TextBox
import com.example.fineduca.components.TopMenu
import androidx.navigation.NavController

@Composable
fun InformationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
    ) {
        // Menu superior com o botão de voltar
        Spacer(modifier = Modifier.height(40.dp))
        TopMenu()

        Spacer(modifier = Modifier.height(20.dp))

        // Botão de voltar
        IconButton(
            onClick = {
                navController.popBackStack() // Navegar para a tela anterior
            },
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Voltar",
                tint = Color.White
            )
        }

        // Conteúdo principal
        Column(
            modifier = Modifier
                .weight(1f) // Ocupa o máximo de espaço disponível
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBox(
                title = "Título 1",
                text = "Caixa 1 - Navegar para outra tela",
                onClick = { println("Caixa 1 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Título 2",
                text = "Caixa 2 - Configurações",
                onClick = { println("Caixa 2 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Título 3",
                text = "Caixa 3 - Configurações",
                onClick = { println("Caixa 3 clicada!") }
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
