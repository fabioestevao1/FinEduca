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
fun CaixaDeSelecao(
    label: String,
    placeHolder: String,
    value: String,
    options: List<String>,
    modifier: Modifier = Modifier,
    atualizarValor: (String) -> Unit
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
            text = if (selectedOption.isNotEmpty()) selectedOption else placeHolder,
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
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                        atualizarValor(option)
                    }
                )
            }
        }
    }
}
