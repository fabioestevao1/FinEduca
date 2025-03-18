package com.example.fineduca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
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

        Spacer(modifier = Modifier.height(40.dp))
        TopMenu()

        Spacer(modifier = Modifier.height(20.dp))

        // Botão de voltar
        IconButton(
            onClick = {
                navController.popBackStack()
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
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBox(
                title = "Juros Simples ou Compostos?",
                text = "Descubra qual a diferença dessas duas formas de calculo de investimentos, e entenda descubra qual a melhor.",
                onClick = { println("Caixa 1 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "O que são Investimentos de Renda Fixa?",
                text = "Aprenda sobre os tipos de investimento, e porque voce deve começar investindo em ativos de Renda Fixa.",
                onClick = { println("Caixa 2 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Pré ou Pós fixado? Qual o melhor?",
                text = "Qual tipo de investimento escolher? Diversos fatores devem ser levados em conta na hora de decidir em qual investir.",
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