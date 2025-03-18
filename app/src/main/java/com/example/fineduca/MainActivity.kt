package com.example.fineduca

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fineduca.navigation.AppNavGraph
import com.example.fineduca.ui.theme.FinEducaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Habilita o modo de tela cheia (Edge-to-Edge)

        setContent {
            FinEducaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Criação do NavController que gerencia a navegação entre telas
                    val navController = rememberNavController()

                    // Usando Scaffold como ponto de entrada para futuras adições (ex: barra de navegação, botões, etc.)
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            // Passa o navController para o AppNavGraph para controlar a navegação
                            AppNavGraph(navController)
                        }
                    )
                }
            }
        }
    }
}
