package com.example.fineduca.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fineduca.R

// Definição correta da FontFamily
val Poppins = FontFamily(
    Font(R.font.poppins_regular) // Certifique-se de que o arquivo poppins_regular está na pasta res/font/
)

// Definindo estilos de tipografia com a fonte personalizada
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Poppins, // Agora estamos usando a fonte personalizada Poppins
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    // Outros estilos de tipografia podem ser definidos aqui, se necessário
)
