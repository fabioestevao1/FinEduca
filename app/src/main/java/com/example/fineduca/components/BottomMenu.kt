package com.example.fineduca.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fineduca.ui.theme.MainBlue
import com.example.fineduca.ui.theme.MainGreen


@Composable
fun BottomMenu(modifier: Modifier) {
    // Estado para controlar o ícone selecionado
    var selectedItem by remember { mutableStateOf(0) }

    // Ícones do menu inferior
    val icons = listOf(
        Icons.Filled.Home,  // Ícone de Home
        Icons.Filled.Menu,  // Ícone de Pesquisa
        Icons.Filled.Face,  // Ícone de Notificação
        Icons.Filled.Settings // Ícone de Conta
    )

    // Descrição dos ícones para título (opcional)
    val iconTitles = listOf("Home", "Menu", "Account","Settings")

    // Componente de Row que alinha os ícones horizontalmente
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MainBlue),
        horizontalArrangement = Arrangement.SpaceEvenly,  // Espaçamento igual entre ícones
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Loop através dos ícones para exibir e adicionar a interação de seleção
        icons.forEachIndexed { index, icon ->
            IconButton(
                onClick = {
                    selectedItem = index // Atualiza o ícone selecionado
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = iconTitles[index],
                    tint = if (selectedItem == index) MainGreen else Color.White,  // Altera cor quando selecionado
                    modifier = Modifier.size(30.dp)  // Tamanho do ícone
                )
            }
        }
    }
}