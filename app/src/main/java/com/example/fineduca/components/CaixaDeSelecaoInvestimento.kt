package com.example.fineduca.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CaixaDeSelecaoInvestimento(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    atualizarValor: (String) -> Unit
) {
    val opcoesInvestimento = listOf("LCI", "LCA", "Poupança", "CDB", "Fundo de Investimento")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(value) }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Text(
            text = if (selectedOption.isNotEmpty()) selectedOption else "Selecione o tipo de investimento",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(vertical = 8.dp),
            fontSize = 16.sp,
            color = Color.Black
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opcoesInvestimento.forEach { opcao ->
                DropdownMenuItem(
                    text = { Text(opcao) },
                    onClick = {
                        selectedOption = opcao
                        expanded = false
                        atualizarValor(opcao)
                    }
                )
            }
        }
    }
}
