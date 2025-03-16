package com.example.fineduca.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Botao(
    text: String,
    color: Color,
    modifier: Modifier = Modifier // Deixando opcional
) {
    Button(
        onClick = {},
        modifier = modifier
    ) {
        Text(text = text)
    }
}
