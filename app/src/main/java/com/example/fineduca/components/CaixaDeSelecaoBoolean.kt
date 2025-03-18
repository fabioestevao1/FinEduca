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
fun CaixaDeSelecaoBoolean(
    label: String,
    value: Boolean?,
    modifier: Modifier = Modifier,
    atualizarValor: (Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(value) }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Text(
            text = when (selectedOption) {
                true -> "Pré-fixado"
                false -> "Pós-fixado"
                null -> "Selecione uma opção"
            },
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
            DropdownMenuItem(
                text = { Text("Pré-fixado") },
                onClick = {
                    selectedOption = true
                    expanded = false
                    atualizarValor(true)
                }
            )
            DropdownMenuItem(
                text = { Text("Pós-fixado") },
                onClick = {
                    selectedOption = false
                    expanded = false
                    atualizarValor(false)
                }
            )
        }
    }
}
